package com.recruitment.controller;

import com.recruitment.domain.User;
import com.recruitment.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 李江涛
 */

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userServic;

    @RequestMapping("/findAllUser")
    public List<User> findAllUser(){
        List<User> all = userServic.findAll();
        return all;
    }
    @RequestMapping("/findById")
    public User findById(@RequestBody User user){
        Integer userId=user.getUserId();
        return userServic.findById(userId);
    }

    @RequestMapping("/update")
    public User ban(@RequestBody User user){

        return userServic.saveAndFlush(user);
    }
    @RequestMapping("/save")
    public User save(@RequestBody User user){
        return userServic.save(user);
    }

}
