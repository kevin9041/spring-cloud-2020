/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.controller;

import com.wei.springcloud.service.IdGeneratorSnowFlakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weihuanbo
 * @version SnowFlakeController: SnowFlakeController.java, v0.1 2022/5/15 weihuanbo Exp $$
 */
@RestController
public class SnowFlakeController {
    @Autowired
    private IdGeneratorSnowFlakeService snowFlakeService;

    @RequestMapping(value = "/testSnowFlake", method = RequestMethod.GET)
    public String testSnowFlake() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        StopWatch stopWatch = new StopWatch("雪花算法");
        stopWatch.start();
        for (int i = 1; i < 200000; i++) {
            threadPool.submit(() -> {
                System.out.println(snowFlakeService.snowflakeId());
            });
        }
        stopWatch.stop();
        System.out.println("耗时：" + stopWatch.getTotalTimeSeconds());
        threadPool.shutdown();
        return "测试成功";
    }

}