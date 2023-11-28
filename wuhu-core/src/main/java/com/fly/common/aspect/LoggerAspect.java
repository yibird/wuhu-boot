package com.fly.common.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description 日志切面类
 * @Author zchengfeng
 * @Date 2023/3/14 10:35
 */
@Aspect
@Component
public class LoggerAspect {
    @Pointcut("@annotation(com.fly.common.annotation.Logger)")
    public void pointcut(){}

    @Before("pointcut()")
    public void beforeAdvice(){

    }

    @After("pointcut()")
    public void afterAdvice(){

    }
}
