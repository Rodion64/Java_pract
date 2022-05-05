package com.example.task15.repos;

import com.example.task15.Entity.GameAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameAuthorRepo extends JpaRepository<GameAuthor, Long> {
    GameAuthor findGameAuthorByName(String name);

}
