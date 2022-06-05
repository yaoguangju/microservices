package com.mochen.auth.dubbo;

import com.mochen.dubbo.auth.TestService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class TestServiceImpl implements TestService {
    @Override
    public String test(String name) {
        return "hello " + name;
    }
}
