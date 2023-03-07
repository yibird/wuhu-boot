package com.fly.common.cache;

import org.springframework.cache.Cache;

import java.util.concurrent.Callable;

/**
 * @Description 缓存管理器
 * @Author zchengfeng
 * @Date 2023/2/22 10:16
 */
public class CacheManager implements Cache {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Object getNativeCache() {
        return null;
    }

    @Override
    public ValueWrapper get(Object key) {
        return null;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        return null;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {

    }

    @Override
    public void evict(Object key) {

    }

    @Override
    public void clear() {

    }
}
