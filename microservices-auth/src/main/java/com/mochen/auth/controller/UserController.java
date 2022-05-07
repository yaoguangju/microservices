package com.mochen.auth.controller;


import com.mochen.auth.entity.xdo.UserDO;
import com.mochen.auth.mapper.UserMapper;
import com.mochen.core.common.xbo.ResultBO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 学生 前端控制器
 * </p>
 *
 * @author 姚广举
 * @since 2022-05-07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/getUserList")
    public ResultBO<List<UserDO>> getUserList(){
        List<UserDO> userDOS = userMapper.selectList(null);
        return new ResultBO<>(userDOS);
    }

}

