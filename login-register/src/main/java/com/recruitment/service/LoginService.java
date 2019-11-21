package com.recruitment.service;

import com.recruitment.domain.User;

/**
 * @Author: 陈琪文
 * @Date: 2019/11/13 14:59
 */
public interface LoginService{
    String  sendphone(String userphone);

    String  phonelogin(String userphone,String code);

    String passlogin(User user);

    String  phoneregister(String userphone, String code);

    String registercheck(String userphone);
}
