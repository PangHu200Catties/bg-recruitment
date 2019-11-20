package com.recruitment.service;

import com.recruitment.domain.User;

import java.util.List;

/**
 * @Author: 李江涛
 * @Date: 2019/11/16 11:39
 */
public interface userService {

    List<User> findAll();

    User saveAndFlush(User user);


    User findById(Integer userId);

    User save(User user);
}
