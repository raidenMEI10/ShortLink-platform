package com.nageoffer.shortlink.admin.dto.req;

import lombok.Data;

/**
 * 短连接分组更新请求实体对象
 */
@Data
public class ShortLinkGroupUpdateReqDTO {
    /**
     * 分组id
     */
    private String gid  ;
    /**
     * 分组名
     */
    private String name;
}
