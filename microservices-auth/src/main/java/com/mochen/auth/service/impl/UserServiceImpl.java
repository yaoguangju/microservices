package com.mochen.auth.service.impl;


import com.mochen.auth.entity.dto.LoginDTO;
import com.mochen.auth.entity.vo.LoginVO;
import com.mochen.auth.entity.xdo.UserDO;
import com.mochen.auth.mapper.UserMapper;
import com.mochen.auth.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mochen.redis.common.manager.RedisManager;
import com.mochen.security.entity.LoginUser;
import com.mochen.security.manager.JwtManager;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 学生 服务实现类
 * </p>
 *
 * @author 姚广举
 * @since 2022-05-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements IUserService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private JwtManager jwtManager;

    @Resource
    private RedisManager redisManager;

    @Override
    public LoginVO login(LoginDTO loginDTO) {

        // 用户登录前的前置判断，比如验证码等，判断通过后找到需要验证的账号密码
        // 将登录用户账号（可能多种类型），密码传入Security系统
        // Security系统的UserDetailsServiceImpl会调用loadUserByUsername的方法去数据源查询该用户，封装成UserDetails对象
        // 同时Security系统调用UsernamePasswordAuthenticationToken生成需要验权的user对象
        // 将UserDetails对象和user对象做对比，如果成功便通过
        // 登录接口将UserDetails的权限存储到redis中
        // 增加JwtAuthenticationTokenFilter过滤所有的HTTP请求，解析token获取uid，查询用户权限放入authenticationToken中，存储到线程的SecurityContextHolder中
        // 最终到达controller层
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

//        if(Objects.isNull(authenticate)){
//            throw new CommonException("用户名或密码错误");
//        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Long userId = loginUser.getUser().getId();
        Long year = loginUser.getUser().getYear();

        String token = jwtManager.createToken(userId,year);
        redisManager.setCacheObject("login:"+ userId, loginUser);
        //封装前端对象
        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);
        LoginVO.UserVO userVO = new LoginVO.UserVO();
        BeanUtils.copyProperties(loginUser.getUser(),userVO);
        loginVO.setUserVO(userVO);

        return loginVO;
    }

    @Override
    public void logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        redisManager.deleteObject("login:"+userid);
    }
}
