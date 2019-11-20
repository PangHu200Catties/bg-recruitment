package com.recruitment.service.impl;

import com.recruitment.domain.User;
import com.recruitment.mapper.UserRepository;
import com.recruitment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author 贾振乾
 * Date 2019/11/14
 * Time 11:45
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User findUserByUserId(int uid) {
        User user =userRepository.findByUserId(uid);

        return userRepository.findByUserId(uid);
    }

    @Override
    public String updateUser(User user) {
       try {
           userRepository.saveAndFlush(user);
       }catch (Exception e){
           e.printStackTrace();
           return "失败";
       }
        return "成功";
    }
}
