package com.recruitment.service.Impl;

import com.recruitment.dao.AddressRespository;
import com.recruitment.domain.Address;
import com.recruitment.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 张浩
 * @Date: 2019/11/21 20:01
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRespository addressRespository;
    @Override
    public void uploadAddress(Address address) {
        addressRespository.saveAndFlush(address);
    }
}
