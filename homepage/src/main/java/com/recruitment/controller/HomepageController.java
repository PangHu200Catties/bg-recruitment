package com.recruitment.controller;

import com.recruitment.domain.CompanySet;
import com.recruitment.domain.Position;
import com.recruitment.service.HomepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 吴佐彬
 * @Date: 2019/11/13
 * @Time: 15:09
 * @description:
 */
@RestController
public class HomepageController {

    @Autowired
    private HomepageService homepageService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/listPosition")
    public List<CompanySet> listPosition(){
        return homepageService.listPosition();
    }
}
