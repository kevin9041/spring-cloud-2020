/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author weihuanbo
 * @version ConfigMain3355: ConfigMain3355.java, v0.1 2022/4/10 weihuanbo Exp $$
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3355.class, args);
    }

}