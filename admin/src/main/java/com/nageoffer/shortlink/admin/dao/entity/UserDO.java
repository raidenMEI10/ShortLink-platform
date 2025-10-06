package com.nageoffer.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.nageoffer.shortlink.admin.common.database.BaseDO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户持久层实现
 *
 * @TableName t_user
 */
@Data
@TableName("t_user")
public class UserDO extends BaseDO implements Serializable {

    @TableId(type = IdType.AUTO)
    /**
     * ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 注销时间戳
     */
    private Long deletionTime;



}
