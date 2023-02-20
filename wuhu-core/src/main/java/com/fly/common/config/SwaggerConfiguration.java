package com.fly.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description Swagger配置类
 * @Author zchengfeng
 * @Date 2023/2/20 19:54
 */
@Configuration
public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi userApi() {
        String[] paths = {"/**"};
        String[] packagedToMatch = {"com.fly"};
        return GroupedOpenApi.builder().group("WuhuBoot")
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName("zchengfeng 2684837849@qq.com");
        return new OpenAPI().info(new Info()
                .title("WuhuBoot")
                .description("wuhu-admin java server")
                .contact(contact)
                .version("1.0")
                .termsOfService("https://wuhu.com")
                .license(new License().name("MIT")
                        .url("https://wuhu.com")));
    }
}
