package com.fly.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description Spring异步配置类
 * @Author zchengfeng
 * @Date 2023/3/14 10:40
 */
@Configuration
@EnableAsync
public class AsyncConfiguration {
    @Bean
    public ThreadPoolTaskExecutor executor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 线程池核心数
        taskExecutor.setCorePoolSize(2);
        // 线程池最大数量,只有在缓冲队列满了之后才会申请超过核心线程数的线程
        taskExecutor.setMaxPoolSize(10);
        // 缓冲队列容量
        taskExecutor.setQueueCapacity(1024);
        // 线程的空闲时间(默认60s),当超过了核心线程数之外的线程在空闲时间到达之后会被销毁
        taskExecutor.setKeepAliveSeconds(200);
        // 线程池线程名称前缀
        taskExecutor.setThreadNamePrefix("async-");
        /**
         * 线程池拒绝策略。当线程池的任务缓存队列已满并且线程池中的线程数目达到maximumPoolSize,
         * 如果还有任务到来就会采取任务拒绝策略,常用的几种策略如下:
         * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
         * ThreadPoolExecutor.DiscardPolicy:也是丢弃任务,但是不抛出异常。
         * ThreadPoolExecutor.DiscardOldestPolicy:丢弃队列最前面的任务,然后重新尝试执行任务(重复此过程)。
         * ThreadPoolExecutor.CallerRunsPolicy:重试添加当前的任务,自动重复调用 execute() 方法,直到成功。
         */
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化线程池,设置ExecutorService
        taskExecutor.initialize();
        return taskExecutor;
    }
}
