package com.fly.common.utils;

import jakarta.annotation.Resource;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Description Redis工具类
 * @Author zchengfeng
 * @Date 2023/3/14 10:16
 */
@Component
public class RedisUtils {
    private static RedisTemplate<String, Object> redisTemplate;

    @Resource
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisUtils.redisTemplate = redisTemplate;
    }

    private final static Long KEYS_COUNT = 100L;

    public static void emptyCheck(String k) {
        ThrowableUtils.emptyCheck(k, "key cannot be empty");
    }

    // =================================== key ===================================
    public static long getDBKeySize() {
        return ThrowableUtils.handle(() -> {
            int size = Optional.ofNullable(redisTemplate.keys("*"))
                    .orElse(new HashSet<>()).size();
            return Long.valueOf(size);
        }, () -> 0L);
    }

    public static DataType getKeyType(String k) {
        emptyCheck(k);
        return ThrowableUtils.handle(() -> redisTemplate.type(k));
    }

    public static boolean modifyKey(String k, String newK) {
        ThrowableUtils.emptyCheck(k, "key cannot be empty");
        return ThrowableUtils.handle(() -> redisTemplate.rename(k, newK));
    }

    public static Object get(String k) {
        return ThrowableUtils.emptyCheck(k, redisTemplate.opsForValue().get(k));
    }

    public static boolean set(String k, Object v) {
        emptyCheck(k);
        return ThrowableUtils.handle(() -> redisTemplate.opsForValue().set(k, v));
    }

    public static boolean set(String k, Object v, long timeout) {
        emptyCheck(k);
        return ThrowableUtils.handle(() -> redisTemplate.opsForValue().set(k, v, Duration.ofSeconds(timeout)));
    }

    public static boolean set(String k, Object v, long timeout, TimeUnit unit) {
        emptyCheck(k);
        return ThrowableUtils.handle(() -> redisTemplate.opsForValue().set(k, v, timeout, unit));
    }

    public static boolean hasKey(String k) {
        if (null == k) return false;
        return ThrowableUtils.handle(() -> redisTemplate.hasKey(k), () -> false);
    }

    public static boolean del(String k) {
        if (null == k) return true;
        return ThrowableUtils.handle(() -> redisTemplate.delete(k), () -> false);
    }

    public static boolean del(Collection<String> keys) {
        Long size = redisTemplate.delete(keys);
        return size != null && size > 0;
    }

    public static Object getAndDel(String k) {
        return ThrowableUtils.tryFinally(() -> null == k ? null : get(k), () -> del(k));
    }

    public static Set<String> keys(String prefix) {
        return keys(prefix, KEYS_COUNT);
    }

    public static Set<String> keys(String prefix, Long count) {
        Set<String> set = new HashSet<>();
        ScanOptions scanOptions = ScanOptions.scanOptions().match(prefix + "*").count(count).build();
        Cursor<Object> cursor = redisTemplate.executeWithStickyConnection(conn -> new ConvertingCursor<>(conn.scan(scanOptions), redisTemplate.getKeySerializer()::deserialize));
        while (true) {
            assert cursor != null;
            if (!cursor.hasNext()) break;
            set.add(String.valueOf(cursor.next()));
        }
        cursor.close();
        return set;
    }

    // =================================== string ===================================
    public static Long incr(String k) {
        return incr(k, 1);
    }

    public static Long decr(String k) {
        return decr(k, 1);
    }

    public static Long incr(String k, long delta) {
        emptyCheck(k);
        if (delta < 0) throw new RuntimeException("delta must be greater than 0");
        return redisTemplate.opsForValue().increment(k, delta);
    }

    public static Long decr(String k, long delta) {
        emptyCheck(k);
        if (delta < 0) throw new RuntimeException("delta must be greater than 0");
        return redisTemplate.opsForValue().decrement(k, delta);
    }

    public static Object getAndSet(String k, Object v) {
        try {
            Object oldVal = get(k);
            set(k, v);
            return oldVal;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean append(String k, String v) {
        emptyCheck(k);
        return ThrowableUtils.handle(() -> {
            redisTemplate.opsForValue().append(k, v);
        });
    }

    // =================================== sets ===================================

    // =================================== maps ===================================
}
