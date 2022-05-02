//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.wei.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    @Value("${pament.service.url}")
    private String pamentServiceUrl;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getServerPort", method = RequestMethod.GET)
    public String getServerPort() {
        return restTemplate.getForObject(pamentServiceUrl + "/payment/getServerPort", String.class);
    }
}
