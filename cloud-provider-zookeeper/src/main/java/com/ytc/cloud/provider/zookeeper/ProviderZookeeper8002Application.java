package com.ytc.cloud.provider.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : yetc
 * @date : 2020/6/14 19:02
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderZookeeper8002Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderZookeeper8002Application.class,args);
    }
}
