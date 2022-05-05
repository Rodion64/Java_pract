package com.example.task14;

import java.util.ArrayList;

public class GameAuthor {
    private String name;
    private ArrayList<Game> games = new ArrayList<>();

    public void addGame(Game game) {
        games.add(game);
    }

    public boolean deleteGame(String nameOfGame) {
        for(Game game : games) {
            if(game.getName().equals(nameOfGame)) games.remove(game);
            return true;
        }
        return false;
    }

    public Game getGameByName (String nameOfGame) {
        for(Game game : games) {
            if(game.getName().equals(nameOfGame)) games.remove(game);
            return game;
        }
        return null;
    }

    public GameAuthor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "GameAuthor{" +
                "name='" + name + '\'' +
                ", games=" + games +
                '}';
    }
}
