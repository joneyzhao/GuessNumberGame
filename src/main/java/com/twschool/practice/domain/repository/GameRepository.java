package com.twschool.practice.domain.repository;

import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GuessNumberGame;

public class GameRepository {
    public GuessNumberGame create() {
        return new GuessNumberGame(new AnswerGenerator());
    }
}
