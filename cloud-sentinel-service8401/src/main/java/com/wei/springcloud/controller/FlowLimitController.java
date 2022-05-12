/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weihuanbo
 * @version FlowLimitController: FlowLimitController.java, v0.1 2022/5/12 weihuanbo Exp $$
 */
@RestController
public class FlowLimitController {
    @RequestMapping(value = "/testA", method = RequestMethod.GET)
    public String testA() {
        return "--------testA";
    }

    @RequestMapping(value = "/testB", method = RequestMethod.GET)
    public String testB() {
        return "--------testB";
    }
}