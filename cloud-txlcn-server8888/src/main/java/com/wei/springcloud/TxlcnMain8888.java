/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author weihuanbo
 * @version TxlcnMain8888: TxlcnMain8888.java, v0.1 2022/5/17 weihuanbo Exp $$
 */
@SpringBootApplication
@EnableTransactionManagerServer
@EnableDiscoveryClient
public class TxlcnMain8888 {
    public static void main(String[] args) {
        SpringApplication.run(TxlcnMain8888.class, args);
    }
}