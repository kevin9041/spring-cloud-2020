/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud;

import com.wei.rebbon.RibbonSelfRuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author weihuanbo
 * @version OrderEurekaMain80: OrderEurekaMain80.java, v0.1 2022/2/7 weihuanbo Exp $$
 */
@SpringBootApplication
@EnableEurekaClient
//注意：RibbonSelfRuleConfiguration 配置自定义轮询规则的配置类不要放在主启动类同级及其子路径下
// 准确来说不可放在@ComponentScan扫描的路径及其子路径下
@RibbonClient(name = "cloud-payment-service", configuration = RibbonSelfRuleConfiguration.class)
public class OrderEurekaMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderEurekaMain80.class, args);
    }
}