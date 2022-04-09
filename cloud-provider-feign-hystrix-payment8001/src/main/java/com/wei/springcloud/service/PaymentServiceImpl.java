//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.wei.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    //===================服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数，默认20
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),//时间窗口期，默认5s
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率%达到多少后跳闸，默认50
    })
    @Override
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("******* id 不能为负数");
        }
        String seialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t 调用成功，流水号:" + seialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return Thread.currentThread().getName() + "\t 调用失败:id不能为负数";
    }
}
