package com.recruitment.service.Impl;

import com.recruitment.domain.Hr;
import com.recruitment.service.hrService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @Author: 李江涛
 * @Date: 2019/11/18 11:23
 */
public class hrServiceImpl implements hrService {
    @Autowired
    private com.recruitment.dao.hrJpa hrJpa;
    @Override
    public List<Hr> findAll() {
        return hrJpa.findAll();
    }

    @Override
    public Hr saveAndFlush(Hr hr) {
        return hrJpa.saveAndFlush(hr);
    }

    @Override
    public Hr findById(Integer hrId) {
        Optional<Hr> byId = hrJpa.findById(hrId);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            return null;
        }
    }

    @Override
    public Hr save(Hr hr) {
        return hrJpa.save(hr);
    }
}