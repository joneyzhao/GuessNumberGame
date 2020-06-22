package com.twschool.practice.domain.repository;

import com.twschool.practice.domain.GuessNumberGame;
import org.junit.Assert;
import org.junit.Test;

public class GameRepositoryTest {
    @Test
    public void should_create_game() {
        GameRepository gameRepository = new GameRepository();

        GuessNumberGame guessNumberGame = gameRepository.create();

        Assert.assertNotNull(guessNumberGame);
    }
}
