package com.fly.common.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @Description CacheManager
 * @Author zchengfeng
 * @Date 2023/3/13 14:17
 */
@Component
public class CacheManager {

    @Autowired
    CaffeineCacheProperty caffeineCacheProperty;


    public Cache caffeineCache() {
        return new CaffeineCache(Caffeine.newBuilder()
                .initialCapacity(caffeineCacheProperty.getInitialCapacity())
                .maximumSize(caffeineCacheProperty.getMaximumSize())
                .expireAfterAccess(caffeineCacheProperty.getExpireAfterAccess(), TimeUnit.MILLISECONDS)
                .expireAfterWrite(caffeineCacheProperty.getExpireAfterWrite(), TimeUnit.MILLISECONDS)
                .buildAsync()
                .synchronous()
        );
    }

    public Cache redisCache() {
        return new RedisCache();
    }

    @Bean
    public Cache cache() {
        return new MultipleCache.MultipleCacheBuilder()
                .nextNode(caffeineCache())
                .nextNode(redisCache())
                .build();
    }
}
