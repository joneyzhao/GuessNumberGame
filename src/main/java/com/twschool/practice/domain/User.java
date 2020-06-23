package com.twschool.practice.domain;

import com.twschool.practice.domain.repository.GameRepository;
import com.twschool.practice.domain.service.GameService;

import java.util.HashMap;
import java.util.Map;

public class User {
    public GameService gameService;

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

    public int getTotalGameScores() {
        return totalGameScores;
    }

    public int getTotalSuccesTimes() {
        return totalSuccesTimes;
    }

//    public GameService getGameService() {
//        return gameService;
//    }


    public Map getResultMap(String params){
        Map resultMap = new HashMap();
        String resultStr = gameService.getUserGuessResultString(params);

        this.totalGameScores = gameService.getTotalGameScores();
        this.totalSuccesTimes = gameService.getTotalSuccesTimes();
        resultMap.put("ResultStr", resultStr);
        return resultMap;
    }

}
