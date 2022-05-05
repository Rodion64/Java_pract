package com.example.task14;

import java.util.ArrayList;

public class ServiceDAO {
    public static ArrayList<GameAuthor> listGameAuuthor = new ArrayList<>();

    public static boolean addGameAuthor(GameAuthor temp) {
        if (listGameAuuthor == null) {
            listGameAuuthor.add(temp);
            return true;
        }
        for (GameAuthor gameAuthor : listGameAuuthor) {
            if (gameAuthor.getName().equals(temp.getName())) return false;
        }
        listGameAuuthor.add(temp);
        return true;
    }

    public static boolean deleteGameAuthorByName(String name) {
        if (listGameAuuthor == null) {
            return false;
        }
        for (GameAuthor gameAuthor : listGameAuuthor) {
            if (gameAuthor.getName().equals(name)) {
                listGameAuuthor.remove(gameAuthor);
                return true;
            }
        }
        return false;
    }

    public static GameAuthor findGameAuthorByName(String name) {
        if(listGameAuuthor == null) {
            return null;
        }
        for(GameAuthor gameAuthor: listGameAuuthor) {
            if(gameAuthor.getName().equals(name)) {
                return gameAuthor;
            }
        }
        return null;
    }
}
