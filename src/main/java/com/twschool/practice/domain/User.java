package com.twschool.practice.domain;

import com.twschool.practice.domain.repository.GameRepository;
import com.twschool.practice.domain.service.GameService;

import java.util.HashMap;
import java.util.Map;

public class User {
    public GameService gameService;

    public GameService getGameService() {
        return gameService;
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    public String userId;

    public int totalGameScores = 0;
    public int totalSuccesTimes = 0;

    public User(){

    }
    public User(String userId){
        System.out.println("====" + userId);
        this.userId = userId;

        GameRepository gameRepository = new GameRepository();
        gameService = new GameService(gameRepository );
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

    public Map getResultMap(String params){
        String resultStr = gameService.getUserGuessResultString(params);
        Map resultMap = new HashMap();

        resultMap.put("ResultStr", resultStr);
        return resultMap;
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
