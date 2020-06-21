package com.yetc.cloudcusmerorder8080.my;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : yetc
 * @date : 2020/6/15 20:48
 */
@Configuration
public class MyRibbonRule{

    @Bean
    public IRule getRule(){
        return new AvailabilityFilteringRule();
    }
}
