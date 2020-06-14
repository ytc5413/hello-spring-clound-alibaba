package com.yetc.cloudproviderpayment8001.mysql.mapper;

import com.yetc.cloud.api.common.entity.CloudOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author : yetc
 * @date : 2020/6/13 16:36
 */
@Mapper
public interface CloudOrderMapper {


    public int saveOrder(CloudOrder order);

    @Select("select id,order_no from cloud_order where id = #{id}")
    public CloudOrder getOrderById(int id);
}
