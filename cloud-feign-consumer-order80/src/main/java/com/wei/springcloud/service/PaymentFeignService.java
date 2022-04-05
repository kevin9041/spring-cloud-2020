/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.service;

import com.wei.springcloud.entities.Payment;
import com.wei.springcloud.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author weihuanbo
 * @version PaymentFeignService: PaymentFeignService.java, v0.1 2022/4/4 weihuanbo Exp $$
 */
@Component
//@FeignClient(name = "cloud-payment-service")//name 不用区分大小写
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //value 区分大小写
public interface PaymentFeignService {

    @RequestMapping(value = "/payment/getPaymentById/{paymentId}", method = RequestMethod.GET)
    CommonResult<Payment> getPaymentById(@PathVariable("paymentId") Long paymentId);
}