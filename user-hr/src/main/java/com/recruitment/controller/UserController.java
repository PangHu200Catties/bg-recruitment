package com.recruitment.controller;


import com.recruitment.domain.UserSet;

import com.recruitment.service.UserSetService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



/**
 * Author 王凯
 * Date 2019/11/14
 * Time 10:24
 */
@RestController
public class UserController {
    @Autowired
    private UserSetService userSetService;


    //简历信息查询展示
    @RequestMapping("/resume/{id}")

    public UserSet findAllById(@PathVariable("id") int id) {
        return userSetService.findAllById(id);
    }

    //修改简历的屏蔽状态
    @RequestMapping("/findHide/{id}")
    public void  findHide(@PathVariable("id") int id){
        userSetService.findHide(id);
    }

    @PostMapping("/updateHide")
    public void updateHide(@RequestBody UserSet userSet) {
        userSetService.updateHide(userSet);
    }

    /*resume.vue
    * 简历详情修改
    * */
    @PostMapping("/updateResume")
    public void updateData(@RequestBody UserSet userSet) {
        userSetService.updateResume(userSet);
    }

}
