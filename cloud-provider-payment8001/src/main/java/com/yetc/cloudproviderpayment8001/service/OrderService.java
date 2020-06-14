package com.yetc.cloudproviderpayment8001.service;


import com.yetc.cloud.api.common.entity.CloudOrder;

/**
 * @author : yetc
 * @date : 2020/6/13 16:48
 */
public interface OrderService {

    public int saveOrder(CloudOrder order);

    CloudOrder getOrderById(Integer id);
}
