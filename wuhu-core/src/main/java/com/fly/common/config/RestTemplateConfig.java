package com.fly.common.config;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;


/**
 * @DescriptionRestTemplate配置类
 * @Author zchengfeng
 * @Date: 2023/7/23 23:01
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory requestFactory(HttpClient client) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(client);
        return factory;
    }

    /**
     * @Description创建RequestConfig实例,用于配置 HttpClient
     * 的请求参数和超时时间等设置
     * @Author zchengfeng
     * @Date: 2023/7/23 23:35
     * @Return: RequestConfig实例
     */
    public RequestConfig requestConfig() {
        return RequestConfig.custom()
                // 连接超时时间20s
                .setConnectTimeout(20, TimeUnit.SECONDS)
                // 获取连接超时时间10s
                .setConnectionRequestTimeout(10,TimeUnit.SECONDS)
                // 响应超时时间20s
                .setResponseTimeout(20,TimeUnit.SECONDS)
                .build();
    }

    @Bean
    public HttpClient httpClient() {
        /**
         * PoolingHttpClientConnectionManager是Apache HttpComponents库中
         * 的一个类,它实现了连接池管理,可以有效地复用HTTP连接
         */
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        // 设置连接池最大连接数
        manager.setMaxTotal(500);
        // 设置每一个路由默认的最大连接数
        manager.setDefaultMaxPerRoute(300);
        return HttpClientBuilder
                .create()
                .setDefaultRequestConfig(requestConfig())
                .setConnectionManager(manager)
                .build();
    }
}