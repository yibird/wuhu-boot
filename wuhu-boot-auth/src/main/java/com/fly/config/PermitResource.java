package com.fly.config;

import com.fly.utils.StringUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Component
public class PermitResource {
    private final static String IGNORE_AUTH_URL_KEY = "auth.ignore_urls";

    /**
     * 获取忽略认证的请求列表
     *
     * @return 忽略认证的请求列表
     */
    @SneakyThrows
    public List<String> getPermitList() {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:auth.yml");
        return getPropertiesList(IGNORE_AUTH_URL_KEY, resources);
    }

    /**
     * 根据属性key从Resource列表获取对应的值
     *
     * @param key       属性key
     * @param resources Resource列表
     * @return 返回指定key属性对应的值列表
     */
    public List<String> getPropertiesList(String key, Resource... resources) {
        List<String> list = new ArrayList<>();
        Arrays.stream(resources).forEach((resource) -> {
            Properties properties = readYamlProperties(resource);
            properties.forEach((key1, value) -> {
                String tmpKey = StringUtils.substringBefore(key1.toString(), "[");
                if (tmpKey.equalsIgnoreCase(key)) {
                    list.add(value.toString());
                }
            });
        });
        return list;
    }

    /**
     * 从Resource列表读取yaml属性
     *
     * @param resources Resource列表
     * @return 返回一个 Properties对象
     */
    private Properties readYamlProperties(Resource... resources) {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resources);
        factory.afterPropertiesSet();
        return factory.getObject();
    }
}
