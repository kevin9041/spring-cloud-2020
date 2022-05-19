/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.wei.springcloud.mapper.ZhangSanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * @author weihuanbo
 * @version ZhangSanService: ZhangSanService.java, v0.1 2022/5/17 weihuanbo Exp $$
 */
@Service
public class ZhangSanService {
    @Autowired
    private ZhangSanMapper zhangSanMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    public void addZhangSanAccountMoney() {
        zhangSanMapper.addZhangSanAccountMoney();
        restTemplate.getForObject("http://cloud-txlcn-client6666/service6666/addLiSiAccountMoney", String.class);
        int a = 10 / 0;
    }
}