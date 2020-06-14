package com.yetc.cloud.api.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : yetc
 * @date : 2020/6/13 22:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloudUser {
    private String name;
    private int age;
}
