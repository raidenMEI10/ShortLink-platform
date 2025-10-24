package com.nageoffer.shortlink.project.dto.req;

import lombok.Data;

/**
 * 回收站恢复请求DTO
 */
@Data
public class RecycleBinRecoverReqDTO {

    public String gid;

    private String fullShortUrl;
}
