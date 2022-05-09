package com.mochen.auth.common.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mochen.auth.entity.xdo.UserDO;
import com.mochen.auth.mapper.UserMapper;
import com.mochen.security.entity.LoginUser;
import com.mochen.security.entity.SecurityUserDO;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 自定义userDetailsService - 认证用户详情
 * </p>
 *
 * @author qy
 * @since 2019-11-08
 *
 *
 * Spring Security在进行认证的时候，会UserDetailsService接口的loadUserByUsername方法，去查询应该有用户信息
 * 然后封装成UserDetails对象，如果然后根据自定义的密码规则匹配客户端传来的密码是否正确
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    /***
     * 根据账号获取用户信息
     * @param username:
     * @return: org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        UserDO userDO;
        wrapper.eq("phone", username);
        userDO = userMapper.selectOne(wrapper);
        //TODO 根据用户查询权限信息 添加到LoginUser中
        List<String> list = new ArrayList<>(Collections.singletonList(userDO.getRole()));
        SecurityUserDO securityUserDO = new SecurityUserDO();
        BeanUtils.copyProperties(userDO,securityUserDO);
        return new LoginUser(securityUserDO,list);

    }

}
