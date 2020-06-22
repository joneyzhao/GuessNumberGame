package com.twschool.practice.domain.service;

import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.repository.GameRepository;
import org.junit.Test;
import org.mockito.Mockito;

public class GameServiceTest {

    @Test
    public void should_return_result_when_input_number() {
        GameRepository gameRepository = Mockito.mock(GameRepository.class);
        GuessNumberGame guessNumberGame = Mockito.mock(GuessNumberGame.class);
        Mockito.when(gameRepository.find()).thenReturn(guessNumberGame);
        GameService gameService = new GameService(gameRepository);

        gameService.guess(" 1 2 3 4");

        Mockito.verify(gameRepository, Mockito.times(1)).find();
        Mockito.verify(guessNumberGame, Mockito.times(1)).guess(Mockito.any());
    }

}
