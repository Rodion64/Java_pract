package com.example.task15.services;

import com.example.task15.Entity.Game;
import com.example.task15.Entity.GameAuthor;
import com.example.task15.aspect.LogExecutionTime;
import com.example.task15.repos.GameAuthorRepo;
import com.example.task15.repos.GameRepo;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Transactional
@Slf4j
@org.springframework.stereotype.Service
public class Service implements GameAuthorService, GameService{

    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private GameAuthorRepo gameAuthorRepo;

    @LogExecutionTime
    public boolean addGameAuthor(String name) {
        GameAuthor gameAuthor = gameAuthorRepo.findGameAuthorByName(name);
        if (gameAuthor == null) {
            gameAuthor = new GameAuthor();
            gameAuthor.setName(name);
            gameAuthorRepo.save(gameAuthor);
            log.info("game author created");
            return true;
        }
        log.info("game author not created");
        return false;
    }

    @LogExecutionTime
    public boolean deleteGameAuthor(String name) {
        GameAuthor gameAuthor = gameAuthorRepo.findGameAuthorByName(name);
        if (gameAuthor == null) {
            log.info("game author is not exists");
            return false;
        }
        gameAuthorRepo.delete(gameAuthor);
        log.info("game author deleted");
        return true;
    }

    @LogExecutionTime
    public String showingGameAuthor(String name) {
        GameAuthor gameAuthor = gameAuthorRepo.findGameAuthorByName(name);
        if(gameAuthor == null) {
            log.info("game author is not exists");
            return null;
        }

        else {
            log.info("return info about gameauthor");
            return gameAuthor.toString();
        }
    }

    @LogExecutionTime
    public boolean addGame(String nameAuthor, String name, String creationDate) {
        GameAuthor gameAuthor = gameAuthorRepo.findGameAuthorByName(nameAuthor);
        if (gameAuthor == null || gameRepo.findGameByName(name)!=null) {
            log.info("game not created");
            return false;
        }
        Game game = new Game();
        game.setGameAuthor(gameAuthor);
        game.setName(name);
        game.setCreationDate(creationDate);
        gameRepo.save(game);
        log.info("game created");
        return true;
    }

    @LogExecutionTime
    public boolean deleteGame(String name) {
        Game game = gameRepo.findGameByName(name);
        if (game == null) {
            log.info("game not deleted");
            return false;
        }
        gameRepo.delete(game);
        log.info("game deleted");
        return true;
    }

    @LogExecutionTime
    public String showingGame(String name) {
        Game game = gameRepo.findGameByName(name);
        if(game == null) {
            log.info("game is not exists");
            return null;
        }
        else {
            log.info("return info about game");
            return game.toString();
        }
    }
}
