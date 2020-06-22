package com.twschool.practice.domain;

public class GuessNumberGame {
    public static final int MAX_TRY_TIMES = 6;
    public static final String CORRECT_RESULT = "4A0B";
    private final GameAnswer gameAnswer;
    private GameStatus gameStatus = GameStatus.CONTINUED;
    private int leftTryTimes = MAX_TRY_TIMES;
    public static final int ONCETIME_SCORES = 3;
    private int totalGameScores = 0;

    public GuessNumberGame(AnswerGenerator answerGenerator) {
        this.gameAnswer = answerGenerator.generateAnswer();
    }

    public String guess(String userAnswerString) {
        String result = gameAnswer.check(userAnswerString);
        decreaseTryTimes();
        modifyStatus(result);
        getTotalScore(gameStatus);
        return result;
    }

    private void modifyStatus(String result) {
        if (CORRECT_RESULT.equals(result)) {
            gameStatus = GameStatus.SUCCEED;
        } else if (leftTryTimes == 0) {
            gameStatus = GameStatus.FAILED;
        }
    }

    private void getTotalScore(GameStatus status) {
        if (GameStatus.SUCCEED == status) {
            totalGameScores += ONCETIME_SCORES;
        }
        if (GameStatus.FAILED == status) {
            totalGameScores -= ONCETIME_SCORES;
        }
    }

    private void decreaseTryTimes() {
        leftTryTimes --;
    }

    public GameStatus getStatus() {
        return gameStatus;
    }

    public int getTotalGameScores() {
        return totalGameScores;
    }
}
