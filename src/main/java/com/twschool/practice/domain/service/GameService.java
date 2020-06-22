package com.twschool.practice.domain.service;

import com.twschool.practice.domain.GuessNumberGame;

public class GameService {
    private GuessNumberGame guessNumberGame;

    public GameService(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }

    public String guess(String userStr) {
        return guessNumberGame.guess(userStr);
    }
}
