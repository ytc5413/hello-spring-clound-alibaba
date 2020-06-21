package com.yetc.cloud.gateway.conf;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : yetc
 * @date : 2020/6/19 22:34
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level setLogLevel(){
        return Logger.Level.FULL;
    }
}
