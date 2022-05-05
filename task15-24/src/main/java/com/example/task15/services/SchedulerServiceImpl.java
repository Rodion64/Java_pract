package com.example.task15.services;

import com.example.task15.Entity.Game;
import com.example.task15.Entity.GameAuthor;
import com.example.task15.repos.GameAuthorRepo;
import com.example.task15.repos.GameRepo;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@ManagedResource
public class SchedulerServiceImpl implements SchedulerService
{
    @Autowired
    private GameRepo gameRepo;

    @Autowired
    private GameAuthorRepo gameAuthorRepo;

    @ManagedOperation
    @Scheduled(fixedDelay = 10000)
    @Override
    public void saveEntities() {


        try {
            FileWriter fileWriter1 = new FileWriter("C:/DB_log/gameAuthor.txt");
            FileWriter fileWriter2 = new FileWriter("C:/DB_log/game.txt");

            List<GameAuthor> gameAuthorList = gameAuthorRepo.findAll();
            List<Game> games = gameRepo.findAll();

            for(GameAuthor gameAuthor: gameAuthorList) {
                fileWriter1.write(gameAuthor + "\n");
            }

            for(Game game: games) {
                fileWriter2.write(game + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
