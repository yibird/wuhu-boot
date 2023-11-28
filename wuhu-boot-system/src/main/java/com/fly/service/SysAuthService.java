package com.fly.service;

import com.fly.common.model.response.ApiResult;
import com.fly.model.dto.SysAccountLoginDTO;
import com.fly.model.dto.SysMobileLoginDTO;
import com.fly.model.vo.SysTokenVO;

/**
 * @Description 认证服务
 * @Author zchengfeng
 * @Date 2023/7/03 10:30
 */
public interface SysAuthService {

    ApiResult<Boolean> sendCode(String mobile);

    ApiResult<SysTokenVO> loginByAccount(SysAccountLoginDTO login);

    ApiResult<SysTokenVO> loginByMobile(SysMobileLoginDTO login);

    ApiResult<Void> logout(String accessToken);
}
