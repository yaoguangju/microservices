package com.mochen.tutor.controller;

import com.mochen.core.common.xbo.Result;
import com.mochen.dubbo.auth.TestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @DubboReference
    private TestService testService;

    @GetMapping("/test")
    public String test() {
        return testService.test("echo");
    }

    @GetMapping("/test1")
    public Result test1() {
        return Result.success("124321");
    }
}
