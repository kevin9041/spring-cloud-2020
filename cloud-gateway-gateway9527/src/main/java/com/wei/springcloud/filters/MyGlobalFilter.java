/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author weihuanbo
 * @version MyGolbalFilter: MyGolbalFilter.java, v0.1 2022/4/10 weihuanbo Exp $$
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Order {
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> usernameList = exchange.getRequest().getQueryParams().get("username");
        if (CollectionUtils.isEmpty(usernameList)) {
            log.info("*************非法的参数***************");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        log.info("*************全局过滤器验证成功***************");
        return chain.filter(exchange);
    }

    @Override
    public int value() {
        return 0;
    }
}