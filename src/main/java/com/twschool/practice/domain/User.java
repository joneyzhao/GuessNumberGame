package com.twschool.practice.domain;

public class User {

    public String userId;
    public int totalGameScores = 0;
    public int totalSuccesTimes = 0;

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

}
