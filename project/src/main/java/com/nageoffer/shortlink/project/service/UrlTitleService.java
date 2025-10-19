package com.nageoffer.shortlink.project.service;

import java.io.IOException;

/**
 * URL标题服务接口
 */
public interface UrlTitleService {
    /**
     * 根据URL获取标题
     * @param url 目标URL
     * @return URL的标题
     */
    String getTitleByUrl( String url) throws IOException;
}
