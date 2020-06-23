package com.twschool.practice.domain.repository;

import com.twschool.practice.domain.User;
import org.junit.Assert;
import org.junit.Test;

public class UserRepositoryTest {

    @Test
    public void should_return_userInfo_when_create_user(){
        UserRepository userRepository = new UserRepository();
        User newUser = userRepository.createUser("12");
        Assert.assertNotNull(newUser);
    }
}
