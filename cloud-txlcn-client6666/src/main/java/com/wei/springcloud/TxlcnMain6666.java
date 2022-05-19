/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author weihuanbo
 * @version TxlcnMain6666: TxlcnMain6666.java, v0.1 2022/5/17 weihuanbo Exp $$
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
public class TxlcnMain6666 {
    public static void main(String[] args) {
        SpringApplication.run(TxlcnMain6666.class,args);
    }
}