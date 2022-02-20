/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.controller;

import com.wei.springcloud.entities.Payment;
import com.wei.springcloud.vo.CommonResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author weihuanbo
 * @version OrderController: OrderController.java, v0.1 2022/2/20 weihuanbo Exp $$
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {
    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/payment/zk", method = RequestMethod.GET)
    public String getPaymentById() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk/", String.class);
    }
}