/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.springcloud.controller;

import com.wei.springcloud.service.LiSiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weihuanbo
 * @version TxController: TxController.java, v0.1 2022/5/17 weihuanbo Exp $$
 */
@RestController
@RequestMapping(value = "/service6666")
public class TxController {

    @Autowired
    private LiSiService liSiService;

    @RequestMapping(value = "/addLiSiAccountMoney", method = RequestMethod.GET)
    public String addLiSiAccountMoney() {
        liSiService.addLiSiAccountMoney();
        return "SUCCESS";
    }
}