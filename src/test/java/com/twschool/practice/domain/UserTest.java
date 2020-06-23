package com.twschool.practice.domain;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {
    @Test
    public void should_return_game_repository_when_create_repository(){
        User user = new User("12");
        String result = (String) user.getResultMap("1 2 3 4").get("ResultStr");

        Assert.assertEquals("4A0B", result);
        Assert.assertEquals(3, user.getTotalGameScores());
    }
}
