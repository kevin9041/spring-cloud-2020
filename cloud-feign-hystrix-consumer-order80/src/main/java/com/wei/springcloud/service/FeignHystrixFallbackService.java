/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author weihuanbo
 * @version FeignHystrixFallbackService: FeignHystrixFallbackService.java, v0.1 2022/4/5 weihuanbo Exp $$
 */
@Component
public class FeignHystrixFallbackService implements PaymentFeignHystrixService {
    @Override
    public String feignHystrixOk(Long paymentId) {
        return "================OK的方法也不OK了===================";
    }

    @Override
    public String feignHystrixTimeout(Long paymentId) {
        return "================Timeout的降级处理方法来到了新世界===================";
    }
}