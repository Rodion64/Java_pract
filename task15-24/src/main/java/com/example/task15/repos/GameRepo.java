package com.example.task15.repos;

import com.example.task15.Entity.Game;
import com.example.task15.Entity.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GameRepo extends JpaRepository<Game, Long> {
    void deleteAllGameByGameAuthor(GameAuthor gameAuthor);
    Game findGameByName(String name);
}
