package com.fly.common.cache;

import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

/**
 * @Description CaffeineManager
 * @Author zchengfeng
 * @Date 2023/3/13 15:09
 */
public class CaffeineCache implements Cache<String,Object> {
    private final static String CACHE_NAME = "caffeine";
    private com.github.benmanes.caffeine.cache.Cache<String, Object> cache;

    public CaffeineCache(com.github.benmanes.caffeine.cache.Cache cache) {
        this.cache = cache;
    }

    @Override
    public String getName() {
        return CACHE_NAME;
    }

    @Override
    public Object get(String key) {
        return this.cache.get(key, k -> null);
    }

    @Override
    public <T> T get(String key, Class<T> type) {
        return (T) get(key);
    }

    @Override
    public <T> T get(String key, Callable<T> valueLoader) {
        return (T) get(key);
    }

    @Override
    public void set(String key, Object value) {
        this.cache.put(key, value);
    }

    @Override
    public boolean has(String key) {
        ConcurrentMap<String, Object> map = this.cache.asMap();
        return map.containsKey(key);
    }

    @Override
    public void expire(String key) {
        this.cache.invalidate(key);
    }

    @Override
    public void clear() {
        cache.cleanUp();
    }
}
