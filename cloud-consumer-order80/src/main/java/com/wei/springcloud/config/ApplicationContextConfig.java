/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author weihuanbo
 * @version ApplicationContextConfig: ApplicationContextConfig.java, v0.1 2022/2/7 weihuanbo Exp $$
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}