package com.fly;

import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestClient;

/**
 * @Description: 服务启动类
 * @Author: zchengfeng
 * @Data: 2022/12/6 14:24
 */
@SpringBootApplication
public class ServerApplication extends SpringBootServletInitializer implements ApplicationRunner, ApplicationListener<WebServerInitializedEvent> {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ServerApplication.class);
    }

    @Override
    public void onApplicationEvent(@NotNull WebServerInitializedEvent event) {
        String appName = this.getApplicationName(event);
        int port = event.getWebServer().getPort();
        LOGGER.info(appName + " start successfully \uD83C\uDF89,port:" + port);
    }

    private String getApplicationName(WebServerInitializedEvent event) {
        Environment env = event.getApplicationContext().getEnvironment();
        return env.getProperty("spring.application.name");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        RestClient.create()
                .get()
                .uri("http://localhost:9999/")
                .retrieve()
                .body(String.class);
    }
}
