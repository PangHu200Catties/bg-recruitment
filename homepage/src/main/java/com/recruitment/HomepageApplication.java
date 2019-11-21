package com.recruitment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 吴佐彬
 * @Date: 2019/11/12
 * @Time: 17:49
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class HomepageApplication {
    public static void main(String[] args){
        SpringApplication.run(HomepageApplication.class);
    }
}