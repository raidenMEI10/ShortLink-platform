package com.nageoffer.shortlink.project.dto.req;

import lombok.Data;

/**
 * 回收站保存请求DTO
 */
@Data
public class RecycleBinSaveReqDTO {

    public String gid;

    private String fullShortUrl;
}
