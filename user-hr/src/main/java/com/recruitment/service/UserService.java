package com.recruitment.service;

import com.recruitment.domain.User;

/**
 * Author 贾振乾
 * Date 2019/11/14
 * Time 11:44
 */
public interface UserService {
    User findUserByUserId(int uid);

    String updateUser(User user);

}
