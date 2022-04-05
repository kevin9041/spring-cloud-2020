/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.controller;

import com.wei.springcloud.entities.Payment;
import com.wei.springcloud.service.PaymentFeignService;
import com.wei.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weihuanbo
 * @version OrderFeignController: OrderFeignController.java, v0.1 2022/4/5 weihuanbo Exp $$
 */
@RestController
@Slf4j
@RequestMapping(value = "/consumer")
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @RequestMapping(value = "/getPaymentById/{paymentId}", method = RequestMethod.GET)
    public CommonResult<Payment> getPaymentById(@PathVariable("paymentId") Long paymentId){
        return paymentFeignService.getPaymentById(paymentId);
    }
}