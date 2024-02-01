package com.fly.user.service;

import com.fly.common.model.response.ApiResult;

/**
 * @Description 用户服务
 * @Author zchengfeng
 * @Date 2023/7/3 15:48
 */
public interface SysUserService {
    ApiResult<Void> register(String account, String password);
}
