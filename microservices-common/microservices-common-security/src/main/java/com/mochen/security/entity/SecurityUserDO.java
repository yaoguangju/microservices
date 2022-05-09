package com.mochen.security.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 学生
 * </p>
 *
 * @author 姚广举
 * @since 2022-05-07
 */
@Data
@Accessors(chain = true)
public class SecurityUserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private String role;

    /**
     * 姓名
     */
    private String name;

    /**
     * 学校id
     */
    private Long schoolId;

    /**
     * 年级
     */
    private Long year;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 维护时间
     */
    private LocalDateTime updateTime;


}
