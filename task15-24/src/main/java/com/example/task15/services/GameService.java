package com.example.task15.services;

public interface GameService {
    boolean addGame(String nameAuthor, String name, String creationDate);
    boolean deleteGame(String name);
    String showingGame(String name);
}
