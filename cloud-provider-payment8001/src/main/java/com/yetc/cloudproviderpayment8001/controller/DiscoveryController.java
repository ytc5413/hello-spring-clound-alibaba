package com.yetc.cloudproviderpayment8001.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : yetc
 * @date : 2020/6/14 9:56
 */
@Slf4j
@RestController
@RequestMapping("/discovery")
public class DiscoveryController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/info")
    public String getDiscoveryClientInfo(){
        List<String> services = discoveryClient.getServices();
        services.stream().forEach(s -> log.info("service:\t"+s));
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment");
        StringBuilder sb = new StringBuilder();
        for (ServiceInstance instance : instances) {
            sb.append(String.format("service id:%s host:%s:%s uri:%s \n",
                    instance.getServiceId(),instance.getHost(),instance.getPort(),instance.getUri()));
        }
        log.info(sb.toString());
        return sb.toString();
    }

}
