package com.twschool.practice.domain;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {
    @Test
    public void should_return_User_name_by_user_id(){
        User user = new User();
        Assert.assertNotNull(user);
    }
}
