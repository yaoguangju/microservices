package com.mochen.sentinel.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mochen.core.common.enums.ExceptionEnum;
import com.mochen.core.common.xbo.Result;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class UrlBlockHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        String msg = null;
        if(e instanceof FlowException){//限流异常
            msg = "接口已被限流";
        }else if(e instanceof DegradeException){//熔断异常
            msg = "接口已被熔断,请稍后再试";
        }
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        //ObjectMapper是内置Jackson的序列化工具类,这用于将对象转为JSON字符串
        ObjectMapper mapper = new ObjectMapper();
        //某个对象属性为null时不进行序列化输出
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.writeValue(httpServletResponse.getWriter(),
                new Result(ExceptionEnum.INTERFACE_CURRENT_LIMIT.getCode(), msg)
        );
    }
}
