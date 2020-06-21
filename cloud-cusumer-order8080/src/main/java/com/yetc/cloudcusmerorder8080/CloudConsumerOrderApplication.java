package com.yetc.cloudcusmerorder8080;

import com.yetc.cloudcusmerorder8080.my.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : yetc
 * @date : 2020/6/13 18:00
 */
@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "cloud-payment",configuration = {MyRibbonRule.class})
@EnableFeignClients
public class CloudConsumerOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderApplication.class,args);
    }
}
