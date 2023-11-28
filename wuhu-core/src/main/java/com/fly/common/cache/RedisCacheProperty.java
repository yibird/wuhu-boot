package com.fly.common.cache;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description RedisCacheProperty
 * @Author zchengfeng
 * @Date 2023/3/13 17:31
 */
@Configuration
@ConfigurationProperties(prefix = "multiple-cache.redis")
@ToString
@Data
public class RedisCacheProperty {
}
