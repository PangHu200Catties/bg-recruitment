package com.recruitment.service;

import com.recruitment.domain.Hr;

import java.util.List;

/**
 * @Author: 李江涛
 * @Date: 2019/11/16 11:39
 */
public interface hrService {

    List<Hr> findAll();

    Hr saveAndFlush(Hr hr);


    Hr findById(Integer hrId);

    Hr save(Hr hr);
}
