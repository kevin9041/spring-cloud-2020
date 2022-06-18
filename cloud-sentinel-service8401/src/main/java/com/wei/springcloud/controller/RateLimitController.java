/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wei.springcloud.entities.Payment;
import com.wei.springcloud.handleClass.CustomHandleClass;
import com.wei.springcloud.vo.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weihuanbo
 * @version RateLimitController: RateLimitController.java, v0.1 2022/6/18 weihuanbo Exp $$
 */
@RestController
public class RateLimitController {
    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2022L, "byResource"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping(value = "/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2022L, "byUrl"));
    }

    @GetMapping(value = "/byCustomHandleClass")
    @SentinelResource(value = "byCustomHandleClass",
            blockHandlerClass = CustomHandleClass.class,
            blockHandler = "customHandleMethod2")
    public CommonResult byCustomHandleClass() {
        return new CommonResult(200, "按公共处理类限流测试OK", new Payment(2022L, "byCustomHandleClass"));
    }

    @GetMapping(value = "/fallback/{id}")
    @SentinelResource(value = "fallback"
            , fallback = "handleFallback"
            , blockHandler = "handleException"
            , exceptionsToIgnore = {RuntimeException.class})
    public CommonResult fallback(@PathVariable Long id) {
        if (id > 0) {
            return new CommonResult(200, "服务降级测试OK", new Payment(2022L, "fallback"));
        } else {
            throw new RuntimeException();
        }
    }

    public CommonResult handleFallback(@PathVariable Long id, Throwable e) {
        return new CommonResult(5555, "服务降级了,exception内容:" + e.getMessage());
    }
}