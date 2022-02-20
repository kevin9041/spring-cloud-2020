/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author weihuanbo
 * @version OrderZkMain80: OrderZkMain80.java, v0.1 2022/2/20 weihuanbo Exp $$
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解向使用consul或者zookeeper作为服务注册中心时注册服务
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }
}