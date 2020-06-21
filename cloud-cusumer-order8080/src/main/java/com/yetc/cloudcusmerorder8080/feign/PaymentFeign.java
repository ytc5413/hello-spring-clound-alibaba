package com.yetc.cloudcusmerorder8080.feign;

import com.yetc.cloud.api.common.entity.CloudOrder;
import com.yetc.cloud.api.common.entity.CommonResult;
import com.yetc.cloudcusmerorder8080.feign.fallback.PaymentFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : yetc
 * @date : 2020/6/19 20:47
 */
@FeignClient(value = "cloud-payment" ,fallback = PaymentFallback.class)
public interface PaymentFeign {

    @GetMapping("/order/get/{id}")
    public CommonResult<CloudOrder> getOrder(@PathVariable(name="id") Integer id);
}
