package com.yetc.cloudproviderpayment8001.controller;

import com.yetc.cloud.api.common.entity.CloudOrder;
import com.yetc.cloud.api.common.entity.CommonResult;
import com.yetc.cloudproviderpayment8001.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author : yetc
 * @date : 2020/6/13 16:48
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order/save")
    public CommonResult saveOrder(@RequestBody CloudOrder order){
        int result = orderService.saveOrder(order);
        log.info("*****插入结果"+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功");
        }else {
            return new CommonResult(400,"插入数据库失败");
        }
    }

    @GetMapping("/order/get/{id}")
    public CommonResult<CloudOrder> getOrder(@PathVariable(name="id") Integer id){
       log.info("id=="+id);
        CloudOrder order = orderService.getOrderById(id);
        if(order!=null){
            return new CommonResult(200,"查询成功",order);
        }else {
            return new CommonResult(404,"查询失败");
        }
    }
}
