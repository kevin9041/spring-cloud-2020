/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.wei.springcloud.mapper.LiSiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author weihuanbo
 * @version LiSiService: LiSiService.java, v0.1 2022/5/17 weihuanbo Exp $$
 */
@Service
public class LiSiService {
    @Autowired
    private LiSiMapper liSiMapper;

    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    public void addLiSiAccountMoney() {
        liSiMapper.addLiSiAccountMoney();
    }
}