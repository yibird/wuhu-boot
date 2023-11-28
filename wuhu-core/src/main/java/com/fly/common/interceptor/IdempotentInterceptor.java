package com.fly.common.interceptor;

import com.fly.common.annotation.Idempotent;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class IdempotentInterceptor implements HandlerInterceptor {
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public IdempotentInterceptor(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod handlerMethod) {
            Method method = handlerMethod.getMethod();
            Idempotent idempotent = method.getAnnotation(Idempotent.class);
            if (idempotent != null) {
                // 从请求头获取token
                String token = request.getHeader("x-token");
                // 如果token存在,则将token存储在redis中,否则抛出 RuntimeException 异常
                if (Objects.nonNull(token)) {
                    String key = getKey(idempotent,token);
                    boolean isProcessed = redisTemplate.opsForValue().setIfAbsent(key, true, idempotent.expireSeconds(), TimeUnit.SECONDS);
                    if (!isProcessed) {
                        throw new RuntimeException("Duplicate request detected");
                    }
                } else {
                    throw new RuntimeException("Missing x-token header");
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在请求处理完成后执行清理操作
        if (handler instanceof HandlerMethod handlerMethod) {
            Method method = handlerMethod.getMethod();
            Idempotent idempotent = method.getAnnotation(Idempotent.class);
            if (idempotent != null) {
                // 从请求头中获取 Token
                String token = request.getHeader("x-token");
                if (Objects.nonNull(token)) {
                    String key = getKey(idempotent,token);
                    // 请求处理完成后删除 Redis 中的 Token
                    redisTemplate.delete(key);
                }
            }
        }
    }

    public String getKey(Idempotent idempotent, String token) {
        return idempotent.value().isEmpty() ? idempotent.value()
                : idempotent.prefix() + token;
    }
}
