/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author weihuanbo
 * @version PaymentFeignHystrixService: PaymentFeignHystrixService.java, v0.1 2022/4/4 weihuanbo Exp $$
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-FEIGN-HYSTRIX-SERVICE",fallback = FeignHystrixFallbackService.class)
public interface PaymentFeignHystrixService {

    @RequestMapping(value = "/payment/ok/{paymentId}", method = RequestMethod.GET)
    String feignHystrixOk(@PathVariable("paymentId") Long paymentId);

    @RequestMapping(value = "/payment/timeout/{paymentId}", method = RequestMethod.GET)
    String feignHystrixTimeout(@PathVariable("paymentId") Long paymentId);
}