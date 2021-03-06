package com.twschool.practice.domain.service;

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
    public void should_return_genative_3_scores_when_failed() {
        GameService gameService = new GameService((new GameRepository()));
        gameService.getUserGuessResultString("1 8 3 4");
        gameService.getUserGuessResultString("1 8 3 4");
        gameService.getUserGuessResultString("1 8 3 4");
        gameService.getUserGuessResultString("1 8 3 4");
        gameService.getUserGuessResultString("1 9 3 4");
        gameService.getUserGuessResultString("1 4 3 4");
        Assert.assertEquals(-3, gameService.getTotalGameScores());
    }

    @Test
    public void should_return_add_6_scores_when_continuous_success_2_times () {
        GameService gameService = new GameService((new GameRepository()));
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 5 3 4");
        Assert.assertEquals(6, gameService.getTotalGameScores());
    }

    @Test
    public void should_return_add_12_scores_when_continuous_success_2_times_and_failed_once_and_success_2_times () {
        GameService gameService = new GameService((new GameRepository()));
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 5 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        Assert.assertEquals(12, gameService.getTotalGameScores());
    }

    @Test
    public void should_return_add_11_scores_when_continuous_success_3_times () {
        GameService gameService = new GameService((new GameRepository()));
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        Assert.assertEquals(11, gameService.getTotalGameScores());
    }

    @Test
    public void should_return_add_25_scores_when_continuous_success_6_times () {
        GameService gameService = new GameService((new GameRepository()));
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        Assert.assertEquals(25, gameService.getTotalGameScores());
    }

    @Test
    public void should_return_add_20_scores_when_continuous_success_5_times () {
        GameService gameService = new GameService((new GameRepository()));
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        Assert.assertEquals(20, gameService.getTotalGameScores());
    }

    @Test
    public void should_return_add_42_scores_when_continuous_success_10_times () {
        GameService gameService = new GameService((new GameRepository()));
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        gameService.getUserGuessResultString("1 2 3 4");
        Assert.assertEquals(42, gameService.getTotalGameScores());
    }




}
