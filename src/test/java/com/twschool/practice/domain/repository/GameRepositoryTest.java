package com.twschool.practice.domain.repository;

import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.service.GameService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

public class GameRepositoryTest {
    @MockBean
    private GameService gameService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        Mockito.when(gameService.guess(Mockito.any())).thenReturn("4A0B");
    }

    @Test
    public void should_create_game() {
        GameRepository gameRepository = new GameRepository();

        GuessNumberGame guessNumberGame = gameRepository.create();

        Assert.assertNotNull(guessNumberGame);
    }

    @Test
    public void should_find_game(){
        GameRepository gameRepository = new GameRepository();
        GuessNumberGame expectedGuessNumberGame = gameRepository.create();

        GuessNumberGame guessNumberGame = gameRepository.find();

        Assert.assertNotNull(expectedGuessNumberGame);
    }
}
