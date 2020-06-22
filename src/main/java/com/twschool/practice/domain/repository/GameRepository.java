package com.twschool.practice.domain.repository;

import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GuessNumberGame;

public class GameRepository {
    private GuessNumberGame guessNumberGame = new GuessNumberGame(new AnswerGenerator());

    public GuessNumberGame create() {
        GuessNumberGame guessNumberGame = new GuessNumberGame(new AnswerGenerator());
        return guessNumberGame;
    }

    public GuessNumberGame find() {
        return guessNumberGame;
    }
}
