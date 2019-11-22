package com.recruitment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 张浩
 * @Date: 2019/11/13 14:23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DFSApplication {
    public static void main(String[] args) {
        SpringApplication.run(DFSApplication.class);
    }
}
