/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author weihuanbo
 * @version IdGeneratorSnowFlakeService: IdGeneratorSnowFlakeService.java, v0.1 2022/5/15 weihuanbo Exp $$
 */
@Service
@Slf4j
public class IdGeneratorSnowFlakeService {
    private long workId = 0;
    private long datacenterId = 0;

    private Snowflake snowflake = IdUtil.createSnowflake(workId, datacenterId);

    //spring的Bean在创建的时候会进⾏初始化，⽽初始化过程会解析出@PostConstruct注解的⽅法，并反射调⽤该⽅法
    @PostConstruct
    public void init() {
        try {
            workId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workId:{}", workId);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("当前机器的workId获取失败", e);
            workId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long workId, long datacenterId) {
        snowflake = IdUtil.createSnowflake(workId, datacenterId);
        return snowflake.nextId();
    }
}