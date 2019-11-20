package com.recruitment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: 李江涛
 * @Date: 2019/11/19 9:47
 */
@SpringBootApplication
@EnableEurekaServer
public class userhrApplication {
    public static void main(String[] args) {
        SpringApplication.run(userhrApplication.class,args);
    }
}
