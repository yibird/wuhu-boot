package com.fly.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;

public class TenantInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        // 获取租户id
        // Long tenantId = getTenantIdByReuqest(request);
        // 设置租户ID到 request 的 attribute
        request.setAttribute("tenantId", 1L);
        return true;
    }
}
