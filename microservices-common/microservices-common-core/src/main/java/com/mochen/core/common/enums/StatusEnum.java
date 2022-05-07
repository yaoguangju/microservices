package com.mochen.core.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态枚举，是否
 *
 * @author 姚广举
 * @since 2021-02-25
 */
@AllArgsConstructor
@Getter
public enum StatusEnum {

    SUCCESS("success", "成功"),

    ERROR("error", "失败");


    private final String code;

    private final String msg;
}
