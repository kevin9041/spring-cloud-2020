/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author weihuanbo
 * @version LoadBalance: LoadBalance.java, v0.1 2022/3/20 weihuanbo Exp $$
 */
public interface LoadBalance {
    public ServiceInstance getNextInstance(List<ServiceInstance> serviceInstanceList);
}