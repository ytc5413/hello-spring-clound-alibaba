package com.yetc.cloudproviderpayment8001.service.impl;

import com.yetc.cloud.api.common.entity.CloudOrder;
import com.yetc.cloudproviderpayment8001.mysql.mapper.CloudOrderMapper;
import com.yetc.cloudproviderpayment8001.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : yetc
 * @date : 2020/6/13 17:08
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private CloudOrderMapper cloudOrderMapper;


    @Override
    public int saveOrder(CloudOrder order) {
        return cloudOrderMapper.saveOrder(order);
    }

    @Override
    public CloudOrder getOrderById(Integer id) {
        return cloudOrderMapper.getOrderById(id);
    }
}
