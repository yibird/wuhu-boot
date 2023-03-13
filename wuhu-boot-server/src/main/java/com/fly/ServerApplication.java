package com.fly;

import com.fly.common.cache.Cache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @description:服务启动类
 * @author: zchengfeng
 * @data: 2022/12/6 14:24
 */
@SpringBootApplication
public class ServerApplication extends SpringBootServletInitializer implements ApplicationListener<WebServerInitializedEvent> {

    RedisTemplate redisTemplate = new RedisTemplate();

    private static final Logger logger = LogManager.getLogger(ServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ServerApplication.class);
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        String appName = this.getApplicationName(event);
        int port = event.getWebServer().getPort();
        logger.info(appName + " start successfully,port:" + port);
        redisTemplate.opsForValue().set("xxxx","xxxxxxxxx");
//        cache.set("k1","v1");
//        System.out.println("k1:"+cache.get("k1"));
    }

    private String getApplicationName(WebServerInitializedEvent event) {
        Environment env = event.getApplicationContext().getEnvironment();
        return env.getProperty("spring.application.name");
    }
}
