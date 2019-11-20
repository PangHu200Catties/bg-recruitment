package com.recruitment.service;

import com.recruitment.domain.CompanySet;
import com.recruitment.domain.Position;
import com.recruitment.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 吴佐彬
 * @Date: 2019/11/13
 * @Time: 15:38
 * @description:
 */

public interface HomepageService {

    //查询所有用户信息
    List<User> listUser();

    //查询所有职位
    List<CompanySet> listPosition();



}
