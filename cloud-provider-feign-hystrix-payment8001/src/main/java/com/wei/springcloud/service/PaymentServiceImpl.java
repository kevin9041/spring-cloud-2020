//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.wei.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    public PaymentServiceImpl() {
    }

    @Override
    public String paymentInfoOK(Long paymentId) {
        //spring boot 集成的tomcat自带10个线程数量的线程池
        return Thread.currentThread().getName() + "===========OK=============";
    }

    //指定服务降级的方法和触发的条件（此处是响应时间超过3秒）
    @HystrixCommand(fallbackMethod = "paymentInfoHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String paymentInfoTimeOut(Long paymentId) {
        //case 1:超时
        int time = 2000;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //spring boot 集成的tomcat自带10个线程数量的线程池
        return Thread.currentThread().getName() + "========paymentInfoTimeOut==========" + time;

        //case 2:异常
        //int a = 10/0;
        //return "OK";
    }

    public String paymentInfoHandler(Long paymentId) {
        return Thread.currentThread().getName() + "========服务端的服务降级:paymentInfoHandler==========";
    }
}
