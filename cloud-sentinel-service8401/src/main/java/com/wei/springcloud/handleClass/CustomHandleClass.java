/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.handleClass;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wei.springcloud.vo.CommonResult;

/**
 * @author weihuanbo
 * @version CustomHandleClass: CustomHandleClass.java, v0.1 2022/6/18 weihuanbo Exp $$
 */
public class CustomHandleClass {

    public static CommonResult customHandleMethod1(BlockException exception) {
        return new CommonResult(4444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    public static CommonResult customHandleMethod2(BlockException exception) {
        return new CommonResult(4444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }
}