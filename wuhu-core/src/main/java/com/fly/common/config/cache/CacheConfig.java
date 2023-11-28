package com.fly.common.config.cache;

import com.fly.common.config.cache.J2CacheSpringCacheManageAdapter;
import net.oschina.j2cache.J2CacheBuilder;
import net.oschina.j2cache.J2CacheConfig;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;

import java.io.IOException;

/**
 * @Description 缓存配置类
 * @Author zchengfeng
 * @Date 2023/7/24 14:40
 */
public class CacheConfig extends CachingConfigurerSupport {
    @Override
    public CacheManager cacheManager() {
        // 引入配置
        J2CacheConfig config = null;
        try {
            config = J2CacheConfig.initFromConfig("/j2cache.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 生成 J2CacheBuilder
        J2CacheBuilder j2CacheBuilder = J2CacheBuilder.init(config);
        // 构建适配器
        J2CacheSpringCacheManageAdapter j2CacheSpringCacheManageAdapter = new J2CacheSpringCacheManageAdapter(j2CacheBuilder, true);
        return j2CacheSpringCacheManageAdapter;
    }
}
