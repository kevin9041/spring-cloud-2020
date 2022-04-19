/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weihuanbo
 * @version ConfigClientController: ConfigClientController.java, v0.1 2022/4/19 weihuanbo Exp $$
 */
@RestController
public class ConfigClientController {
    @Value("${foo}")
    private String configInfo;

    @RequestMapping(value = "/configInfo", method = RequestMethod.GET)
    public String getConfigInfo() {
        return configInfo;
    }
}