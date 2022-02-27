/**
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.wei.rebbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weihuanbo
 * @version RibbonSelfRuleConfiguration: RibbonSelfRuleConfiguration.java, v0.1 2022/2/27 weihuanbo Exp $$
 */
@Configuration
public class RibbonSelfRuleConfiguration {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}