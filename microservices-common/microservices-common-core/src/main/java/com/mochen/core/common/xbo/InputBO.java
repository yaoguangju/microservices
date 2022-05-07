package com.mochen.core.common.xbo;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一输入对象
 *
 * @author 姚广举
 * @date 2020-11-11
 */
@Data
public class InputBO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long current;
    private Long size;
    private T data;

}
