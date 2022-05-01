/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author weihuanbo
 * @version MessageReceiveService: MessageReceiveService.java, v0.1 2022/5/1 weihuanbo Exp $$
 */
@EnableBinding(Sink.class) //定义消息的接收管道
@Component
public class MessageReceiveService {

    @Value("${server.port}")
    private Integer serverPort;

    @StreamListener(Sink.INPUT)
    public void messageListener(Message<String> message) {
        System.out.println("*****message:" + message.getPayload() + "\t" + serverPort);
    }
}