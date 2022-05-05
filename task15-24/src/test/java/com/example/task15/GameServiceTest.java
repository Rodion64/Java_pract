package com.example.task15;

import com.example.task15.Entity.Game;
import com.example.task15.Entity.GameAuthor;
import com.example.task15.repos.GameAuthorRepo;
import com.example.task15.repos.GameRepo;
import com.example.task15.services.GameAuthorService;
import com.example.task15.services.GameService;
import com.example.task15.services.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {
    @Mock
    private GameRepo gameRepo;
    @Captor
    ArgumentCaptor<Game> captor;
    @Test
    void getGame() {
        Game game = new Game();
        game.setName("CSGO");
        game.setCreationDate("12.12.2002");
        Game game2 = new Game();
        game2.setName("DOTA2");
        game2.setCreationDate("41.24.2441");
        Mockito.when(gameRepo.findAll()).thenReturn(List.of(game, game2));
    }

    @Test
    void saveOrUpdate() {
        Game game = new Game();
        game.setName("PUBG");
        GameService gameService= new Service();
        gameService.addGame("grisha", game.getName(), game.getCreationDate());
        Mockito.verify(gameRepo).save(captor.capture());
        Game captured = captor.getValue();
        Assertions.assertEquals("PUBG",captured.getName());
    }
}
