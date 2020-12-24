package com.sei.springsecurity.demo.dao;

import com.sei.springsecurity.demo.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User user);

}
