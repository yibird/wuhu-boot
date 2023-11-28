package com.fly.common.handler;

import cn.hutool.json.JSONUtil;
import com.fly.common.model.response.ApiResult;
import jakarta.validation.constraints.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;
import java.util.Objects;

/**
 * @Description 结果通知处理程序
 * @Author zchengfeng
 * @Date 2023/2/21 14:50
 */
@ControllerAdvice("com.fly")
public class ResultAdviceHandler implements ResponseBodyAdvice<Object> {
    private final static List<String> types = List.of("String", "byte[]", "ResponseEntity");

    @Override
    public boolean supports(@NotNull MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, @NotNull MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ApiResult) return body;
        if (getReturnName(returnType).equals("void") || Objects.isNull(body)) {
            return ApiResult.ok(body);
        }
        if (isBasicType(returnType)) {
            return JSONUtil.toJsonStr(ApiResult.ok(body));
        }
        return ApiResult.ok(body);
    }

    /**
     * 根据方法参数对象返回方法的返回值类型
     *
     * @param returnType 方法参数对象
     * @return 方法返回值类型
     */
    private String getReturnName(MethodParameter returnType) {
        if (returnType == null || returnType.getMethod() == null) {
            return "";
        }
        return returnType.getMethod().getReturnType().getName();
    }

    /**
     * 根据方法参数对象判断方法的返回值是否是基础数据类型
     *
     * @param returnType 方法参数对象
     * @return 判断方法返回值是否是基础数据类型, 是则返回true, 反之返回false
     */
    private boolean isBasicType(MethodParameter returnType) {
        if (returnType == null || returnType.getMethod() == null) return true;
        String name = returnType.getMethod().getReturnType().getSimpleName();
        return types.contains(name);
    }
}
