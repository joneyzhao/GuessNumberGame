package com.twschool.practice.domain;

import com.twschool.practice.domain.repository.GameRepository;

public class User {
    public GuessNumberGame userMapGame;
    public String userId;

    public int totalGameScores = 0;
    public int totalSuccesTimes = 0;

    public User(){

    }
    public User(String userId){
        System.out.println("====" + userId);
        this.userId = userId;

        GameRepository gameRepository = new GameRepository();
        userMapGame = gameRepository.create();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getTotalGameScores() {
        return totalGameScores;
    }

    public void setTotalGameScores(int totalGameScores) {
        this.totalGameScores = totalGameScores;
    }

    public int getTotalSuccesTimes() {
        return totalSuccesTimes;
    }

    public void setTotalSuccesTimes(int totalSuccesTimes) {
        this.totalSuccesTimes = totalSuccesTimes;
    }

    public GuessNumberGame getUserMapGame() {
        return userMapGame;
    }

    public void setUserMapGame(GuessNumberGame userMapGame) {
        this.userMapGame = userMapGame;
    }

//    public GuessNumberGame seekGameRepository() {
//        GuessNumberGame userMapGame;
//        GameRepository gameRepository = new GameRepository();
//        UserMappingGame userMappingGame = new UserMappingGame();
//        if (null == gameRepository.getGuessNumberGame()) {
//            userMapGame = gameRepository.create();
//        } else {
//            userMapGame = gameRepository.find();
//        }
//        return userMapGame;
//    }
}
