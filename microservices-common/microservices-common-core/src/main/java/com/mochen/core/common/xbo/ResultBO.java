package com.mochen.core.common.xbo;


import com.mochen.core.common.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;


/**
 * 统一结果对象
 *
 * @author 姚广举
 * @date 2020-11-11
 */
@Data
public class ResultBO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code = ResultEnum.SUCCESS.getCode();
    private String msg = ResultEnum.SUCCESS.getMsg();
    private T data;

    /**
     * 默认构造
     */
    public ResultBO() {
        super();
    }

    /**
     * 带数据
     */
    public ResultBO(T data) {
        super();
        this.data = data;
    }

    /**
     * 带数据和消息
     */
    public ResultBO(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    /**
     * 指定返回
     */
    public ResultBO(ResultEnum re) {
        super();
        this.code = re.getCode();
        this.msg = re.getMsg();
    }

    /**
     * 异常返回
     */
    public ResultBO(Throwable e) {
        super();
        this.code = ResultEnum.FAIL.getCode();
        this.msg = e.getMessage();
    }
}

