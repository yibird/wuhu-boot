package com.fly.common.cache;

import org.springframework.lang.Nullable;

import java.util.concurrent.Callable;

/**
 * @Description MultipleCacheNode
 * @Author zchengfeng
 * @Date 2023/3/13 15:05
 */
public class MultipleCacheNode<T extends Cache> implements Cache<String,Object> {
    private T cache;
    private T nextCache;

    public MultipleCacheNode(T cache) {
        this.cache = cache;
    }

    public void setNextCache(T nextCache) {
        this.nextCache = nextCache;
    }

    public boolean hasNextCache() {
        return null != nextCache;
    }

    @Override
    public String getName() {
        return cache.getName();
    }

    @Override
    public Object get(String key) {
        Object value = cache.get(key);
        if (null == value && hasNextCache()) {
            return cache.putIfAbsent(key, value);
        }
        return value;
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
        if (null != cache) {
            if (hasNextCache()) {
                nextCache.set(key, value);
            }
            cache.set(key, value);
        }
    }

    @Override
    public boolean has(String key) {
        if (null != cache) {
            if (null != cache && hasNextCache()) {
                return cache.has(key) && nextCache.has(key);
            }
            return cache.has(key);
        }
        return false;
    }

    @Override
    public void expire(String key) {
        if (null != cache) {
            if (hasNextCache()) {
                nextCache.expire(key);
            }
            cache.expire(key);
        }
    }

    @Override
    public void clear() {
        if (null != cache) {
            if (hasNextCache()) {
                nextCache.clear();
            }
            cache.clear();
        }
    }
}
