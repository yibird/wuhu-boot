package com.fly;

import jakarta.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.client.RestClient;

import java.lang.management.ManagementFactory;

/**
 * @Description 服务启动类
 * @Author zchengfeng
 * @Author 2022/12/6 14:24
 */
@SpringBootApplication
public class ServerApplication extends SpringBootServletInitializer implements ApplicationRunner, ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.version}")
    private String version;

    @Value("${server.port}")
    private int port;

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ServerApplication.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        RestClient.create().get().uri("http://localhost:9999/").retrieve().body(String.class);
    }

    @Override
    public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
        StringBuilder sb = new StringBuilder();
        sb.append(appName).append(" start successfully \uD83C\uDF89,");
        sb.append(" Port: ").append(port);
        sb.append(", Version: ").append(version);
        sb.append(", Pid: ").append(getProcessId());
        LOGGER.info(sb.toString());
    }

    private String getProcessId() {
        return ManagementFactory.getRuntimeMXBean()
                .getName().split("@")[0];
    }
}
