//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.wei.springcloud.controller;

import com.wei.springcloud.entities.Payment;
import com.wei.springcloud.service.PaymentService;
import com.wei.springcloud.vo.CommonResult;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/payment"})
public class PaymentController {
    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
    @Resource
    private PaymentService paymentService;

    public PaymentController() {
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment) {
        int id = this.paymentService.create(payment);
        log.info("*****插入结果:" + id);
        return id > 0 ? new CommonResult(200, "执行成功", id) : new CommonResult(500, "执行失败");
    }

    @RequestMapping(value = "/getPaymentById/{paymentId}", method = RequestMethod.GET)
    public CommonResult getPaymentById(@PathVariable("paymentId") Long paymentId) {
        Payment payment = this.paymentService.getPaymentById(paymentId);
        return payment != null ? new CommonResult(200, "查询成功", payment) : new CommonResult(404, "查询失败");
    }
}
