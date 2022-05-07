package com.mochen.auth.service.impl;

import com.mochen.auth.entity.xdo.UserDO;
import com.mochen.auth.mapper.UserMapper;
import com.mochen.auth.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
