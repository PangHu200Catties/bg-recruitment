package com.recruitment.service.Impl;

import com.recruitment.domain.User;
import com.recruitment.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: 李江涛
 * @Date: 2019/11/16 11:39
 */
@Service
public class userServiceImpl implements userService {
    @Autowired
    private com.recruitment.dao.userJpa userJpa;

    @Override
    public List<User> findAll() {
        return userJpa.findAll();
    }

    @Override
    public User saveAndFlush(User user) {

        return saveAndFlush(user);
    }

    @Override
    public User findById(Integer userId) {
        Optional<User> byId = userJpa.findById(userId);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            return null;
        }


    }

    @Override
    public User save(User user) {
        User s = userJpa.save(user);
        return s;
    }


}
