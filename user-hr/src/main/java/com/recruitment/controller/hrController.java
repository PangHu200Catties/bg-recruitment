package com.recruitment.controller;


import com.recruitment.domain.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 李江涛
 */

@RestController
@RequestMapping("/hr")
public class hrController {

    @Autowired
    private com.recruitment.service.hrService hrService;

    @RequestMapping("/findAllUser")
    public List<Hr> findAllUser(){
        List<Hr> all = hrService.findAll();
        return all;
    }
    @RequestMapping("/findById")
    public Hr findById(@RequestBody Hr hr){
        Integer hrId=hr.getHrId();
        return hrService.findById(hrId);
    }

    @RequestMapping("/update")
    public Hr ban(@RequestBody Hr hr){

        return hrService.saveAndFlush(hr);
    }
    @RequestMapping("/save")
    public Hr save(@RequestBody Hr hr){
        return hrService.save(hr);
    }

}
