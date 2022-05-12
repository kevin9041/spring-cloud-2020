/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author weihuanbo
 * @version ServiceMain8401: ServiceMain8401.java, v0.1 2022/5/12 weihuanbo Exp $$
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMain8401.class, args);
    }
}