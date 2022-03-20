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
 * @version ApplicationContextConfig: ApplicationContextConfig.java, v0.1 2022/2/7 weihuanbo Exp $$
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced //虽然服务注册进了eureka，服务的调用方可以通过注册时的application-name定位到服务的提供者，
                    // 但是具体调用哪个端口不清楚，所以需要开启负载均衡策略，默认使用轮询方式
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}