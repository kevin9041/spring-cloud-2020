/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author weihuanbo
 * @version GatewayMain9527: GatewayMain9527.java, v0.1 2022/4/10 weihuanbo Exp $$
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }

    //除了yml配置，路由配置的第二种方式(实际跳转可能不可用),推荐yml配置
    @Bean
    public RouteLocator customRouteConfig(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("r_image", r -> r.path("/image").uri("http://image.baidu.com/")).build();
        return routes.build();
    }
}