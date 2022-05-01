/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.controller;

import com.wei.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author weihuanbo
 * @version SendMessageController: SendMessageController.java, v0.1 2022/5/1 weihuanbo Exp $$
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @RequestMapping(value = "/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }

}