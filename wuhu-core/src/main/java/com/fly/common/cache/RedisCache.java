package com.fly.common.cache;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;
import java.util.concurrent.Callable;

/**
 * @Description RedisCache
 * @Author zchengfeng
 * @Date 2023/3/13 15:26
 */
public class RedisCache implements Cache<String,Object> {
    private final static String CACHE_NAME = "redisCache";
    private final static String CACHE_PREFIX = "cache-";
    private RedisTemplate<String, Object> redisTemplate = new RedisTemplate();

    public String getKey(String key) {
        return CACHE_PREFIX + key;
    }

    @Override
    public String getName() {
        return CACHE_NAME;
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(getKey(key));
    }

    @Override
    public <T> T get(String key, Class<T> type) {
        return (T) get(getKey(key));
    }

    @Override
    public <T> T get(String key, Callable<T> valueLoader) {
        return (T) get(getKey(key));
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(getKey(key), value);
    }

    @Override
    public boolean has(String key) {
        return redisTemplate.hasKey(getKey(key));
    }

    @Override
    public void expire(String key) {
        redisTemplate.delete(getKey(key));
    }

    @Override
    public void clear() {
        Set<String> keys = redisTemplate.keys(CACHE_PREFIX);
        keys.forEach((key) -> expire(key));
    }
}
