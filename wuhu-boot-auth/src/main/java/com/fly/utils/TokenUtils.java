package com.fly.utils;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Objects;

/**
 * @Description SpringSecurity Token 工具类
 * @Author zchengfeng
 * @Date 2023/6/9 14:31
 */
public class TokenUtils {
    public final static String AUTHORIZATION = "Authorization";
    public final static String ACCESS_TOKEN = "access_token";

    /**
     * 从HttpServletRequest从获取access_token
     *
     * @param req HttpServletRequest
     * @return 访问token
     */
    public static String getAccessToken(HttpServletRequest req) {
        String accessToken = req.getHeader(AUTHORIZATION);
        if (Objects.isNull(accessToken)) {
            accessToken = req.getParameter(ACCESS_TOKEN);
        }
        return accessToken;
    }
}
