/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author weihuanbo
 * @version EurekaMain7002: EurekaMain7002.java, v0.1 2022/2/19 weihuanbo Exp $$
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }
}