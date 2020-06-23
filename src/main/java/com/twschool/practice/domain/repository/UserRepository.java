package com.twschool.practice.domain.repository;

import com.twschool.practice.domain.User;

public class UserRepository {

    private User user;

    public User createUser(String userId) {
       user = new User(userId);
       return user;
    }

    public User seekUser(String userId) {
        return user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
