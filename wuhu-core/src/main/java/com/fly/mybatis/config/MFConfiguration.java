package com.fly.mybatis.config;

import com.mybatisflex.core.tenant.TenantFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Configuration
public class MFConfiguration {
    @Bean
    public TenantFactory tenantFactory(){
        return () -> {
            RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
            if (attributes == null) {
                throw new RuntimeException("");
            }
            Long tenantId = (Long) attributes.getAttribute("tenantId", RequestAttributes.SCOPE_REQUEST);
            return new Object[0];
        };
    }
}
