package com.fly.common.utils;

import java.security.SecureRandom;
import java.util.Base64;

/**
 * @Description token工具类
 * @Author zchengfeng
 * @Date 2023/3/14 10:16
 */
public class TokenUtils {
    private static final int TOKEN_LENGTH = 32;

    /**
     * 生成token
     *
     * @return token
     */
    public static String generate() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[TOKEN_LENGTH];
        secureRandom.nextBytes(tokenBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }

    /**
     * 根据前缀生成token
     *
     * @param prefix 前缀
     * @return token
     */
    public static String generate(String prefix) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[TOKEN_LENGTH];
        secureRandom.nextBytes(tokenBytes);
        return prefix + Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }
}
