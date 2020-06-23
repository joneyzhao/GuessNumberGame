package com.twschool.practice.domain;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {
    @Test
    public void should_return_game_result_when_create_one_user(){
        User user = new User("12");
        String result = (String) user.getResultString("1 2 3 4");

        Assert.assertEquals("4A0B", result);
        Assert.assertEquals(3, user.getTotalGameScores());
    }

    @Test
    public void should_return_game_result_when_create_two_user(){
        User userOne = new User("12");
        User userTwo = new User("11");

        String resultOne = (String) userOne.getResultString("1 2 3 4");
        String resultTwo = (String) userOne.getResultString("1 5 3 4");

        Assert.assertEquals("4A0B", resultOne);
        Assert.assertEquals(3, userOne.getTotalGameScores());

        Assert.assertEquals("3A0B", resultTwo);
        Assert.assertEquals(0, userTwo.getTotalGameScores());
    }

    @Test
    public void should_return_game_result_when_create_two_user_and_one_of_them_continus_success_6_times(){
        User userOne = new User("12");
        User userTwo = new User("11");

        userOne.getResultString("1 2 3 4");
        userOne.getResultString("1 2 3 4");
        userOne.getResultString("1 2 3 4");
        userOne.getResultString("1 2 3 4");
        userOne.getResultString("1 2 3 4");
        userOne.getResultString("1 2 3 4");

        userTwo.getResultString("1 5 3 4");
        userTwo.getResultString("1 5 3 4");
        userTwo.getResultString("1 5 3 4");
        userTwo.getResultString("1 5 3 4");
        userTwo.getResultString("1 5 3 4");
        userTwo.getResultString("1 5 3 4");

        Assert.assertEquals(25, userOne.getTotalGameScores());
        Assert.assertEquals(-3, userTwo.getTotalGameScores());
    }
}
