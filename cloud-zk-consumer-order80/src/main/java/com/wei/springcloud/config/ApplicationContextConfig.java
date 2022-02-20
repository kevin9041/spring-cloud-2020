/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author weihuanbo
 * @version ApplicationContextConfig: ApplicationContextConfig.java, v0.1 2022/2/20 weihuanbo Exp $$
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}