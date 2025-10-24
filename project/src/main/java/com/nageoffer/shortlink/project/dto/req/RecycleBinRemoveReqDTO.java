package com.nageoffer.shortlink.project.dto.req;

import lombok.Data;

/**
 * 回收站移除请求DTO
 */
@Data
public class RecycleBinRemoveReqDTO {
    public String gid;

    private String fullShortUrl;
}
