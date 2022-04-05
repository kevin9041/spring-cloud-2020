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
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/ok/{paymentId}", method = RequestMethod.GET)
    public String hystrixOk(@PathVariable("paymentId") Long paymentId) {
        log.info("==============server port:" + serverPort);
        String result = paymentService.paymentInfoOK(paymentId);
        return result;
    }

    @RequestMapping(value = "/timeout/{paymentId}", method = RequestMethod.GET)
    public String hystrixTimeout(@PathVariable("paymentId") Long paymentId) {
        log.info("==============server port:" + serverPort);
        String result = paymentService.paymentInfoTimeOut(paymentId);
        return result;
    }

}
