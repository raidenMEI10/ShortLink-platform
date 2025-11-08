package com.nageoffer.shortlink.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 用户操作流量风控配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "short-link.flow-limit")
public class UserFlowRiskControlConfiguration {

    /**
     * 是否启用
     */
    private Boolean enable;

    /**
     * 时间窗口，单位秒
     */
    private String timeWindow;

    /**
     * 窗口内最大访问次数
     */
    private Long maxAccessCount;
}
