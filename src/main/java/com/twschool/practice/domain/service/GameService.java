package com.twschool.practice.domain.service;

import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.repository.GameRepository;

public class GameService {
    private GameRepository gameRepository;
    public static final int ONCETIME_SCORES = 3;
    private int totalGameScores = 0;
    private int totalSuccesTimes = 0;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public String getUserGuessResultString(String userGuessResultStr) {
        GuessNumberGame guessNumberGame;
        if (null == gameRepository.getGuessNumberGame()){
            guessNumberGame = gameRepository.create();
            gameRepository.setGuessNumberGame(guessNumberGame);
        } else {
            guessNumberGame = gameRepository.find();
        }
        String userGuessResultString = guessNumberGame.guess(userGuessResultStr);
        getUserTotalScore(guessNumberGame);

        return userGuessResultString;
    }

    public void getUserTotalScore(GuessNumberGame guessNumberGame){
        GameStatus gameStatus =  guessNumberGame.getStatus();
        if (GameStatus.SUCCEED == gameStatus) {
            totalGameScores += ONCETIME_SCORES;
            totalSuccesTimes ++;
        }
        if (GameStatus.FAILED == gameStatus) {
            totalGameScores -= ONCETIME_SCORES;
            totalSuccesTimes = 0;
        }

        if (totalSuccesTimes > 0 && totalSuccesTimes % 3 == 0) {
            getThreeExtraScores();
        }
    }

    private void getThreeExtraScores() {
        int extraScoresTimes = totalSuccesTimes / 3;

        totalGameScores += extraScoresTimes * 2;
    }


    public int getTotalGameScores() {
        return  totalGameScores;
    }
}
