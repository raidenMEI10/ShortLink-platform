package com.nageoffer.shortlink.admin.dto.resp;

import lombok.Data;

@Data
/**
 * 短连接分组返回实体对象
 */
public class ShortLinkGroupRespDTO{
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
     * 分组排序
     */
    private Integer sortOrder;
}
