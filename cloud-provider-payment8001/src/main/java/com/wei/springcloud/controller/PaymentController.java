//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.wei.springcloud.controller;

import com.wei.springcloud.entities.Payment;
import com.wei.springcloud.service.PaymentService;
import com.wei.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;//引入这个包里的：org.springframework.cloud.client.discovery.DiscoveryClient

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment) {
        int id = this.paymentService.create(payment);
        log.info("*****插入结果:" + id);
        return id > 0 ? new CommonResult(200, "执行成功", id) : new CommonResult(500, "执行失败");
    }

    @RequestMapping(value = "/getPaymentById/{paymentId}", method = RequestMethod.GET)
    public CommonResult getPaymentById(@PathVariable("paymentId") Long paymentId) {
        log.info("==============server port:" + serverPort);
        Payment payment = this.paymentService.getPaymentById(paymentId);
        return payment != null ? new CommonResult(200, "查询成功", payment) : new CommonResult(404, "查询失败");
    }

    @RequestMapping(value = "/selfLoadBalance/showServerport", method = RequestMethod.GET)
    public String showServerport() {
        return serverPort;
    }
}
