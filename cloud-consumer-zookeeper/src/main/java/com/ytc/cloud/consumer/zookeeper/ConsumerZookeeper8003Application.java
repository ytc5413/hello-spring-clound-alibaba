package com.ytc.cloud.consumer.zookeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : yetc
 * @date : 2020/6/14 19:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZookeeper8003Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZookeeper8003Application.class,args);
    }
}
