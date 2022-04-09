/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wei.springcloud.service.PaymentFeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weihuanbo
 * @version OrderFeignHystrixController: OrderFeignHystrixController.java, v0.1 2022/4/5 weihuanbo Exp $$
 */
@RestController
@Slf4j
@RequestMapping(value = "/consumer")
@DefaultProperties(defaultFallback = "defaultGlobalFallBack")
public class OrderFeignHystrixController {
    @Autowired
    private PaymentFeignHystrixService paymentFeignHystrixService;

    @RequestMapping(value = "/feign/hystrix/ok/{paymentId}", method = RequestMethod.GET)
    public String feignHystrixOk(@PathVariable("paymentId") Long paymentId) {
        String result = paymentFeignHystrixService.feignHystrixOk(paymentId);
        return result;
    }

    //指定服务降级的方法和触发的条件（此处是响应时间超过1.5秒）
    @HystrixCommand
    //@HystrixCommand(fallbackMethod = "paymentInfoHandler", commandProperties = {
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    //})
    @RequestMapping(value = "/feign/hystrix/timeout/{paymentId}", method = RequestMethod.GET)
    public String feignHystrixTimeout(@PathVariable("paymentId") Long paymentId) {
        String result = paymentFeignHystrixService.feignHystrixTimeout(paymentId);
        return result;
    }

    String paymentInfoHandler(Long paymentId) {
        return Thread.currentThread().getName() + "========客户端服务降级:paymentInfoHandler==========";
    }

    String defaultGlobalFallBack() {
        return Thread.currentThread().getName() + "========全局默认的客户端服务降级==========";
    }
}