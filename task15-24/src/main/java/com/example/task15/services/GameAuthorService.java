package com.example.task15.services;

public interface GameAuthorService {
    boolean addGameAuthor(String name);
    boolean deleteGameAuthor(String name);
    String showingGameAuthor(String name);
}
