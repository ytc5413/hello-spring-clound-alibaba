package com.yetc.cloud.api.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : yetc
 * @date : 2020/6/13 16:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloudOrder {
    private int id;
    private String order_no;
}
