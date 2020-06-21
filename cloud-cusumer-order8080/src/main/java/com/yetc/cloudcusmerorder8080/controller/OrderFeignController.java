package com.yetc.cloudcusmerorder8080.controller;

import com.yetc.cloud.api.common.entity.CloudOrder;
import com.yetc.cloud.api.common.entity.CommonResult;
import com.yetc.cloudcusmerorder8080.feign.PaymentFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : yetc
 * @date : 2020/6/19 20:51
 */
@Slf4j
@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeign paymentFeign;

    @GetMapping("/feign/get/{id}")
    public CommonResult<CloudOrder> getOrder(@PathVariable(name="id") Integer id){
        log.info("------------ web feign call getOrder(): id"+id);
        return paymentFeign.getOrder(id);
    }


}
