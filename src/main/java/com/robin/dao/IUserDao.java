package com.robin.dao;

import com.robin.pojo.User;

import java.util.List;

public interface IUserDao {

    // select all.
    List<User> findAll();

    // select one according to condition.
    User findByCondition(User user);
}
