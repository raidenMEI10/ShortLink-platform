package com.nageoffer.shortlink.project.common.constant;

/**
 * Redis Key 常量
 */
public class RedisKeyConstant {
    /**
     * 短连接跳转key
     */
    public static final String GOTO_SHORT_LINK_KEY = "short-link_goto_%s";

    /**
     * 短连接跳转锁 key
     */
    public static final String LOCK_GOTO_SHORT_LINK_KEY = "short-link_lock_goto_%s";
}
