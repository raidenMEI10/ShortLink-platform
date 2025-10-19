package com.nageoffer.shortlink.project.controller;

import com.nageoffer.shortlink.project.common.convention.result.Result;
import com.nageoffer.shortlink.project.common.convention.result.Results;
import com.nageoffer.shortlink.project.service.UrlTitleService;
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

    private final UrlTitleService urlTitleService;
    /**
     * 根据URL获取标题
     * @param url 目标URL
     * @return URL的标题
     */
    @GetMapping("/api/short-link/v1/title")
    public Result<String> getTitle(@RequestParam("url") String url) throws IOException {

        return Results.success(urlTitleService.getTitleByUrl(url));
    }
}
