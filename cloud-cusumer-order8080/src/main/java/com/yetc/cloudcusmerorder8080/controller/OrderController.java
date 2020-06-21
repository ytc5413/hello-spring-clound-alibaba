package com.yetc.cloudcusmerorder8080.controller;

import com.yetc.cloud.api.common.entity.CloudOrder;
import com.yetc.cloud.api.common.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : yetc
 * @date : 2020/6/13 21:15
 */
@Slf4j
@RestController
@RefreshScope
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.cloud-payment}")
    private String serverURL;

    @GetMapping("/get/{id}")
    public CommonResult<CloudOrder> getOrder(@PathVariable(name="id") Integer id){
        log.info("id=="+id+"url="+serverURL);
        CommonResult result = restTemplate.getForObject(serverURL + "/order/get/" + id, CommonResult.class);
        return result;
    }


}
