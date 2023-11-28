package com.fly.common.aspect;


import com.fly.common.annotation.Idempotent;
import com.fly.common.utils.TokenUtils;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description 幂等性切面类
 * @Author zchengfeng
 * @Date 2023/3/14 10:35
 */
@Aspect
@Component
@AllArgsConstructor
public class IdempotentAspect {

    private final RedisTemplate<String, Object> redisTemplate;

    @Pointcut("@annotation(com.fly.common.annotation.Idempotent)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object handleIdempotent(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = getMethod(joinPoint);
        Idempotent idempotent = method.getAnnotation(Idempotent.class);
        String key = idempotent.value().isEmpty() ? idempotent.value()
                : TokenUtils.generate(idempotent.prefix());
        if (redisTemplate.hasKey(key)) {
            throw new RuntimeException("Duplicate request detected");
        }
        // 标记请求已处理
        redisTemplate.opsForValue().set(key, true);
        try {
            return joinPoint.proceed();
        } finally {
            // 执行完成后删除 Redis 中的标记
            redisTemplate.delete(key);
        }
    }

    private Method getMethod(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }
}
