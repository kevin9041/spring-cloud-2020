//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.wei.springcloud.service;

import com.wei.springcloud.dao.PaymentDao;
import com.wei.springcloud.entities.Payment;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public PaymentServiceImpl() {
    }

    @Override
    public int create(Payment payment) {
        return this.paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return this.paymentDao.getPaymentById(paymentId);
    }
}
