package com.mochen.core.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionEnum {


    // 认证异常
    TOKEN_HAVE_EXPIRE(40001, "token过期"),
    TOKEN_ERROR(40002, "token错误"),

    // 通用异常
    PARAM_ERROR(40000,"参数错误异常"),
    UNIFIED_EXCEPTION(50000,"统一异常"),
    OPEN_FEIGN_ERROR(50001, "openFeign调用失败"),
    SYSTEM_EXCEPTION(99999, "通用异常");


    // 业务异常普通抛出即可

    /**
     * 错误码
     */
    private final int code;

    /**
     * 提示信息
     */
    private final String msg;
}
