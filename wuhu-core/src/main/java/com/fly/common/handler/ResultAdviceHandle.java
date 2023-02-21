//package com.fly.common.handler;
//
//import com.alibaba.fastjson2.JSON;
//import com.fly.common.model.Result;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//import java.util.List;
//import java.util.Objects;
//
///**
// * @Description ResultAdviceHandle
// * @Author zchengfeng
// * @Date 2023/2/21 14:50
// */
//@ControllerAdvice("com.fly")
//public class ResultAdviceHandle implements ResponseBodyAdvice<Object> {
//    @Override
//    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        return true;
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        if (body instanceof Result) {
//            return body;
//        }
//        if (isBasicType(returnType)) {
//            return JSON.toJSONString(Result.ok());
//        }
//        if (getReturnName(returnType).equals("void") || Objects.isNull(body)) {
//            return Result.ok(body);
//        }
//        return Result.ok(body);
//    }
//
//    /**
//     * 根据方法参数对象返回方法的返回值类型
//     *
//     * @param returnType 方法参数对象
//     * @return 方法返回值类型
//     */
//    private String getReturnName(MethodParameter returnType) {
//        if (returnType == null || returnType.getMethod() == null) {
//            return "";
//        }
//        return returnType.getMethod().getReturnType().getName();
//    }
//
//    /**
//     * 根据方法参数对象判断方法的返回值是否是基础数据类型
//     *
//     * @param returnType 方法参数对象
//     * @return 判断方法返回值是否是基础数据类型, 是则返回true, 反之返回false
//     */
//    private boolean isBasicType(MethodParameter returnType) {
//        if (returnType == null || returnType.getMethod() == null) {
//            return true;
//        }
//        String name = returnType.getMethod().getReturnType().getSimpleName();
//        List<String> types = List.of("String", "byte[]", "ResponseEntity");
//        return types.contains(name);
//    }
//}
