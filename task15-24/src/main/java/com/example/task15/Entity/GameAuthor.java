package com.example.task15.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gameAuthor")
@Data
public class GameAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "gameAuthor",fetch=FetchType.LAZY)
    private Set<Game> games = new HashSet<>();

    @Override
    public String toString() {
        return "GameAuthor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
