/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weihuanbo
 * @version FeignLogConfig: FeignLogConfig.java, v0.1 2022/4/5 weihuanbo Exp $$
 */
@Configuration
public class FeignLogConfig {
    @Bean
    public Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}