package com.nageoffer.shortlink.admin.controller;

import com.nageoffer.shortlink.admin.common.convention.result.Result;
import com.nageoffer.shortlink.admin.remote.ShortLinkRemoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * URL标题获取控制器
 */
@RestController
@RequiredArgsConstructor
public class UrlTitleController {

    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };
    /**
     * 根据URL获取标题
     * @param url 目标URL
     * @return URL的标题
     */
    @GetMapping("/api/short-link/admin/v1/title")
    public Result<String> getTitle(@RequestParam("url") String url) throws IOException {
        return shortLinkRemoteService.getTitleByUrl(url);
    }
}
