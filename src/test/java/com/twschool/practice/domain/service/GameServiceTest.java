package com.twschool.practice.domain.service;

import com.twschool.practice.domain.GuessNumberGame;
import org.junit.Test;
import org.mockito.Mockito;

public class GameServiceTest {

    @Test
    public void guess() {
        GuessNumberGame guessNumberGame = Mockito.mock(GuessNumberGame.class);
        GameService gameService = new GameService(guessNumberGame);

        gameService.guess(" 1 2 3 4");

        Mockito.verify(guessNumberGame, Mockito.times(1)).guess(" 1 2 3 4");
    }

}
