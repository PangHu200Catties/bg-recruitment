package com.recruitment.service.impl;

import com.recruitment.dao.AdminLoginRepository;
import com.recruitment.domain.Admin;
import com.recruitment.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author 王凯
 * Date 2019/11/19
 * Time 20:55
 */
@Service
public class AdminLoginServiceImpl implements AdminLoginService {
    @Autowired
    private AdminLoginRepository adminLoginRepository;
    @Override
    public Admin adminLogin(Admin admin) {
        Admin admin1 = adminLoginRepository.findByUsernameAndPassword(admin.getUsername(), admin.getPassword());


        return admin1;
    }
}
