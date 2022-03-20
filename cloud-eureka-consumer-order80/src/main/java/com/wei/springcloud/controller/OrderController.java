//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.wei.springcloud.controller;

import com.wei.springcloud.entities.Payment;
import com.wei.springcloud.lb.LoadBalance;
import com.wei.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL = "http://localhost:8001"; //单机版

    //注册进eureka的服务，可以通过服务名称对外提供服务，取代了ip和端口的方式
    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalance loadBalance;

    @RequestMapping(value = "/payment/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @RequestMapping(value = "/payment/getPaymentById/{paymentId}", method = RequestMethod.GET)
    public CommonResult getPaymentById(@PathVariable("paymentId") Long paymentId) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + paymentId, CommonResult.class);
    }

    @RequestMapping(value = "/payment/getPaymentById/getForEntity/{paymentId}", method = RequestMethod.GET)
    public CommonResult getPaymentByIdGetForEntity(@PathVariable("paymentId") Long paymentId) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + paymentId, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(500, "执行异常");
        }
    }

    @RequestMapping(value = "/selfLoadBalance/showServerport", method = RequestMethod.GET)
    public String showServerport() {
        List<ServiceInstance> services = discoveryClient.getInstances("cloud-payment-service");
        ServiceInstance nextInstance = loadBalance.getNextInstance(services);
        return restTemplate.getForObject(nextInstance.getUri() + "/payment/selfLoadBalance/showServerport", String.class);
    }
}
