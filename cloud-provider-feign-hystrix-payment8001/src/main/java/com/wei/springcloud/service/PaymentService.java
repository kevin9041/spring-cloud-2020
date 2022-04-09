//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.wei.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {
    String paymentInfoOK(Long paymentId);

    String paymentInfoTimeOut(Long paymentId);

    String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
