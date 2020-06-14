package com.yetc.cloudcusmerorder8080;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : yetc
 * @date : 2020/6/13 18:00
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudConsumerOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrderApplication.class,args);
    }
}
