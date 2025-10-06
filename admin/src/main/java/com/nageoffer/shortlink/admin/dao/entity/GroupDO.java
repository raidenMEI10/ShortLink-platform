package com.nageoffer.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @description t_group
 * @author zyx
 * @date 2025-10-06
 */

/**
 * 短连接分组实体
 */
@Data
@TableName("t_group")
public class GroupDO {
    /**
     * ID
     */
    private Long id;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 创建该分组的用户名
     */
    private String username;

    /**
     * create_time
     */
    private Date createTime;

    /**
     * update_time
     */
    private Date updateTime;

    /**
     * del_flag
     */
    private Integer delFlag;

}
