package com.example.task15;

import com.example.task15.Entity.GameAuthor;
import com.example.task15.repos.GameAuthorRepo;
import com.example.task15.services.GameAuthorService;
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
public class GameAuthorServiceTest {
    @Mock
    private GameAuthorRepo gameAuthorRepo;
    @Captor
    ArgumentCaptor<GameAuthor> captor;
    @Test
    void getGameAuthor() {
        GameAuthor gameAuthor = new GameAuthor();
        gameAuthor.setName("Vasya");
        GameAuthor gameAuthor2 = new GameAuthor();
        gameAuthor2.setName("Grisha");
        Mockito.when(gameAuthorRepo.findAll()).thenReturn(List.of(gameAuthor, gameAuthor2));
    }

    @Test
    void saveOrUpdate() {
        GameAuthor gameAuthor = new GameAuthor();
        gameAuthor.setName("John");
        GameAuthorService gameAuthorService= new Service();
        gameAuthorService.addGameAuthor(gameAuthor.getName());
        Mockito.verify(gameAuthorRepo).save(captor.capture());
        GameAuthor captured = captor.getValue();
        Assertions.assertEquals("John",captured.getName());
    }


}
