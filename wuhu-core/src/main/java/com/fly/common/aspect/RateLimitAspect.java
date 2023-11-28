package com.fly.common.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RateLimitAspect {

    @Pointcut("@annotation(com.fly.common.annotation.RateLimit)")
    public void pointcut() {
    }
}
