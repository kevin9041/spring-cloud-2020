//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.wei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //该注解向使用consul或者zookeeper作为服务注册中心时注册服务
public class PaymentMain8004 {
    public PaymentMain8004() {
    }

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
