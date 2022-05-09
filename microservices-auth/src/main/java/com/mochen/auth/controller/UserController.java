package com.mochen.auth.controller;


import com.mochen.auth.entity.dto.LoginDTO;
import com.mochen.auth.entity.vo.LoginVO;
import com.mochen.auth.entity.xdo.UserDO;
import com.mochen.auth.mapper.UserMapper;
import com.mochen.auth.service.IUserService;
import com.mochen.core.common.xbo.Result;
import com.mochen.core.exception.CommonException;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    private IUserService userService;


    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO loginDTO) throws CommonException {
        LoginVO loginVO = userService.login(loginDTO);
        return Result.success(loginVO);
    }

    @PostMapping("/logout")
    public Result logout() throws CommonException {
        userService.logout();
        return Result.success();
    }

    @GetMapping("/getUserList")
    public Result getUserList(){
        List<UserDO> userDOS = userMapper.selectList(null);
        return Result.success(userDOS);
    }

}

