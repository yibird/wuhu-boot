package com.fly.common.cache;

import org.springframework.lang.Nullable;

import java.util.concurrent.Callable;

/**
 * @Description Cache接口,定义了缓存相关方法,例如获取缓存、判断key是否存在、设置缓存等
 * @Author zchengfeng
 * @Date 2023/3/13 15:44
 */
public interface Cache<K extends String,V> {
    String getName();

    @Nullable
    Object get(K key);

    @Nullable
    <T> T get(K key, @Nullable Class<T> type);

    @Nullable
    <T> T get(K key, Callable<T> valueLoader);

    void set(K key, @Nullable Object value);

    boolean has(K key);

    default Object putIfAbsent(K key, @Nullable Object value) {
        if (!has(key)) {
            set(key, value);
        }
        return get(key);
    }
    void expire(K key);
    default boolean expireIfPresent(K key) {
        expire(key);
        return false;
    }
    void clear();

    default boolean invalidate() {
        clear();
        return false;
    }
}
