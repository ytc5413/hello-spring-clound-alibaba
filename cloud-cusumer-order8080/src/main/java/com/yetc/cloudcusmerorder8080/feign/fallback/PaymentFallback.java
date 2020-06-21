package com.yetc.cloudcusmerorder8080.feign.fallback;

import cn.hutool.http.HttpStatus;
import com.yetc.cloud.api.common.entity.CloudOrder;
import com.yetc.cloud.api.common.entity.CommonResult;
import com.yetc.cloudcusmerorder8080.feign.PaymentFeign;

/**
 * @author : yetc
 * @date : 2020/6/19 21:11
 */
public class PaymentFallback  implements PaymentFeign {
    @Override
    public CommonResult<CloudOrder> getOrder(Integer id) {

        return new CommonResult<>(HttpStatus.HTTP_UNAVAILABLE,"服务繁忙，请稍后再试");
    }
}
