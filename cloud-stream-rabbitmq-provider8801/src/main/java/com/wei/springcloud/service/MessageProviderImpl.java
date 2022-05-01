/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author weihuanbo
 * @version MessageProviderImpl: MessageProviderImpl.java, v0.1 2022/5/1 weihuanbo Exp $$
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    @Output(Source.OUTPUT) //在注入MessageChannel的时候，表明注入的是哪种通道
    private MessageChannel outputChannel; //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        outputChannel.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial:" + serial);
        return null;
    }
}