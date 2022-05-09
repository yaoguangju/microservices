package com.mochen.auth.service;

import com.mochen.auth.entity.dto.LoginDTO;
import com.mochen.auth.entity.vo.LoginVO;
import com.mochen.auth.entity.xdo.UserDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 学生 服务类
 * </p>
 *
 * @author 姚广举
 * @since 2022-05-07
 */
public interface IUserService extends IService<UserDO> {

    LoginVO login(LoginDTO loginDTO);

    void logout();
}
