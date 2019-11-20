package com.recruitment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Author 贾振乾
 * Date 2019/10/17
 * Time 14:47
 */
//springboot启动类
@SpringBootApplication
//注册中心客户端注解
@EnableDiscoveryClient
//负载均衡与实现Http客户端
@EnableFeignClients
//熔断与服务降级注解
@EnableCircuitBreaker

////包扫描配置
//@ComponentScan(basePackages = {"com.recruitment.mapper","com.recruitment.controller", "com.recruitment.service"})

public class HrAndUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(HrAndUserApplication.class,args);
    }
}
