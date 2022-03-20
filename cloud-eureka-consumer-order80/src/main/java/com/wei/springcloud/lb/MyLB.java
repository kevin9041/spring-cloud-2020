/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author weihuanbo
 * @version MyLB: MyLB.java, v0.1 2022/3/20 weihuanbo Exp $$
 */
@Component
public class MyLB implements LoadBalance {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrementRequest() {
        int current;
        int next;
        for (; ; ) {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            if (atomicInteger.compareAndSet(current, next)) {
                return next;
            }
        }
    }

    @Override
    public ServiceInstance getNextInstance(List<ServiceInstance> serviceInstanceList) {
        int next = getAndIncrementRequest() % serviceInstanceList.size();
        return serviceInstanceList.get(next);
    }
}