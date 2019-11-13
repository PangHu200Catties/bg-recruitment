package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: 吴佐彬
 * @Date: 2019/11/12
 * @Time: 10:01
 * @description:
 */
@SpringBootApplication
@EnableEurekaServer
public class ServerApplication {
    public static void main(String[] args){
        SpringApplication.run(ServerApplication.class);
    }

}
