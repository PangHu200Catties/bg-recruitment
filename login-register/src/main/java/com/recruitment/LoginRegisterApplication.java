package com.recruitment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: 陈琪文
 * @Date: 2019/11/13 12:02
 */
@SpringBootApplication
@EnableEurekaClient
public class LoginRegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginRegisterApplication.class);
    }
}
