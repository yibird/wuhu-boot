package com.fly.common.cache;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description CaffeineCacheProperty
 * @Author zchengfeng
 * @Date 2023/3/13 16:30
 */
@Configuration
@ConfigurationProperties(prefix = "multiple-cache.caffeine")
@ToString
@Data
public class CaffeineCacheProperty {
    private int expireAfterAccess = 100;
    private int initialCapacity = 100;
    private Long maximumSize = 1000L;
    private Long expireAfterWrite = 10000L;
    private Long refreshAfterWrite = 10000L;

}
