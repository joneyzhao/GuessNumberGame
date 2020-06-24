package com.twschool.practice.domain;

import com.twschool.practice.domain.repository.GameRepository;
import com.twschool.practice.domain.service.GameService;


public class User {
    public GameService gameService;
    public String userId;
    public int totalGameScores = 0;
    public int totalSuccesTimes = 0;

    public User(String userId){
        this.userId = userId;

        GameRepository gameRepository = new GameRepository();
        gameService = new GameService(gameRepository );
    }

    public int getTotalGameScores() {
        return totalGameScores;
    }


    public String getResultString(String answerString){
        String resultStr = gameService.getUserGuessResultString(answerString);

        this.totalGameScores = gameService.getTotalGameScores();
        this.totalSuccesTimes = gameService.getTotalSuccesTimes();
        return resultStr;
    }

}
