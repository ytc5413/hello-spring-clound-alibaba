package com.yetc.cloud.api.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : yetc
 * @date : 2020/6/13 16:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String desc;
    private T resp;

    public CommonResult(Integer code, String desc) {
       this(code,desc,null);
    }
}
