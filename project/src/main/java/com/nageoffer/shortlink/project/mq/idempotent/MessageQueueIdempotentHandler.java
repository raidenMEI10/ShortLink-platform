package com.nageoffer.shortlink.project.mq.idempotent;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 消息队列幂等处理器
 */
@Component
@RequiredArgsConstructor
public class MessageQueueIdempotentHandler {

    private final StringRedisTemplate stringRedisTemplate;

    private static final String IDEMPOTENT_KEY_PREFIX = "short-link:idempotent:";

    /**
     * 判断消息是否已被消费过
     * @param messageId 消息唯一标识
     * @return 是否被消费
     */
    public boolean isMessageProcessed(String messageId) {
        String key = IDEMPOTENT_KEY_PREFIX + messageId;
        // 状态 “0” 代表执行中 “1”代表已消费完成
        return Boolean.TRUE.equals(stringRedisTemplate.opsForValue().setIfAbsent(key, "0" , 10 , TimeUnit.MINUTES)); // 判断是否存在，不存在则设置MQ唯一标识，10分钟过期
    }

    /**
     * 判断消息是否已完成处理
     * @param messageId
     * @return
     */
    public boolean isAccomplish(String messageId) {
        String key = IDEMPOTENT_KEY_PREFIX + messageId;
        return Objects.equals(stringRedisTemplate.opsForValue().get(key),"1");
    }

    /**
     * 标记消息已完成处理
     * @param messageId
     */
    public void setAccomplish(String messageId) {
        String key = IDEMPOTENT_KEY_PREFIX + messageId;
        stringRedisTemplate.opsForValue().set(key,"1",60,TimeUnit.MINUTES);
    }
    /**\
     *
     * 如果消息处理遇到异常情况主动删除幂等标识，允许重新消费
     * @param messageId
     */
    public void delMessageProcessed(String messageId) {
        String key = IDEMPOTENT_KEY_PREFIX + messageId;
        stringRedisTemplate.delete(key);
    }
}
