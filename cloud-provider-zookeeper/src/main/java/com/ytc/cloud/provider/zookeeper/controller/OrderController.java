package com.ytc.cloud.provider.zookeeper.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author : yetc
 * @date : 2020/6/14 19:06
 */
@RequestMapping("/order")
@RestController
public class OrderController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/zk/{id}")
    public String getOrder(@PathVariable("id") Integer id){
        return "port:"+port+" id="+id+" uuid"+ UUID.randomUUID().toString();
    }
}
