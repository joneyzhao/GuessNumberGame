package com.twschool.practice.domain.service;

import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.repository.GameRepository;

public class GameService {
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public String guess(String userStr) {
        GuessNumberGame guessNumberGame = gameRepository.find();
        return guessNumberGame.guess(userStr);
    }
}
