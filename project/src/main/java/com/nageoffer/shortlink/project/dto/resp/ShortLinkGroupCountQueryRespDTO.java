package com.nageoffer.shortlink.project.dto.resp;

import lombok.Data;

/**
 * 短链接分组查询返回对象
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {

    /**
     * 分组标识
     */
    private String gid;

    private Integer shortLinkCount;
}
