package com.recruitment;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: 吴佐彬
 * @Date: 2019/11/13
 * @Time: 9:55
 * @description:
 */
@SpringBootApplication
@EnableAdminServer
public class AdminApplication {
    public static void main(String[] args){
        SpringApplication.run(AdminApplication.class);
    }
}
