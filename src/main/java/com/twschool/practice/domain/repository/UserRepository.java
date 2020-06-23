package com.twschool.practice.domain.repository;

import com.twschool.practice.domain.User;

public class UserRepository {


    public User createUser(String userId) {
        return new User(userId);
    }
}
