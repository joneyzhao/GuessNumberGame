package com.twschool.practice.domain.service;

import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.repository.GameRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class GameServiceTest {

    @Test
    public void should_return_result_when_input_number() {
        GameRepository gameRepository = Mockito.mock(GameRepository.class);
        GuessNumberGame guessNumberGame = Mockito.mock(GuessNumberGame.class);

        Mockito.when(gameRepository.create()).thenReturn(guessNumberGame);

        GameService gameService = new GameService(gameRepository);
        gameService.getUserGuessResultString(" 1 2 3 4");

        Mockito.verify(gameRepository, Mockito.times(1)).create();
        Mockito.verify(guessNumberGame, Mockito.times(1)).guess(Mockito.any());
    }

    @Test
    public void should_add_3_scores_when_success() {
        GameService gameService = new GameService((new GameRepository()));
        gameService.getUserGuessResultString("1 2 3 4");
        Assert.assertEquals(3, gameService.getTotalGameScores());
    }

    @Test
    public void should_return_minus_3_scores_when_failed() {
        GameService gameService = new GameService((new GameRepository()));
        gameService.getUserGuessResultString("1 8 3 4");
        gameService.getUserGuessResultString("1 8 3 4");
        gameService.getUserGuessResultString("1 8 3 4");
        gameService.getUserGuessResultString("1 8 3 4");
        gameService.getUserGuessResultString("1 9 3 4");
        gameService.getUserGuessResultString("1 4 3 4");
        Assert.assertEquals(-3, gameService.getTotalGameScores());
    }

}
