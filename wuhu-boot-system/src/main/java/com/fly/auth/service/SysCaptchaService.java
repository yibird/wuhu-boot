package com.fly.auth.service;

import com.fly.common.model.response.ApiResult;

/**
 * @Description 验证码服务
 * @Author zchengfeng
 * @Date 2023/7/03 14:30
 */
public interface SysCaptchaService {
    /**
     * 生成base64格式的验证码
     *
     * @return base64格式的验证码
     */
    ApiResult<String> generate();

    /**
     * 校验验证码是否正确
     *
     * @param code 验证码
     * @return 验证码正确返回true, 否则返回false
     */
    boolean validate(String code);
}
