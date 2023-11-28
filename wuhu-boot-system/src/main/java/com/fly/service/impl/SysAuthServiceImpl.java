package com.fly.service.impl;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.RandomUtil;
import com.fly.common.exception.ApiStatus;
import com.fly.common.exception.ServerException;
import com.fly.common.model.response.ApiResult;
import com.fly.common.utils.ThrowableUtils;
import com.fly.mapper.SysUserMapper;
import com.fly.model.domain.SysUserDO;
import com.fly.model.dto.SysAccountLoginDTO;
import com.fly.model.dto.SysMobileLoginDTO;
import com.fly.model.vo.SysTokenVO;
import com.fly.service.SysAuthService;
import com.fly.service.SysCaptchaService;
import com.fly.store.TokenStore;
import com.fly.user.UserDetail;
import com.fly.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @Description 认证服务实现类
 * @Author zchengfeng
 * @Date 2023/7/03 10:30
 */
@Service
@AllArgsConstructor
public class SysAuthServiceImpl implements SysAuthService {
    private static final Logger LOGGER = LogManager.getLogger();

    private final SysUserMapper userMapper;
    private final SysCaptchaService captchaService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final TokenStore tokenStore;

    @Override
    public ApiResult<SysTokenVO> loginByAccount(SysAccountLoginDTO loginDTO) {
        // 1.校验验证码是否有效
        boolean validate = captchaService.validate(loginDTO.getCaptcha());
        if (!validate) throw new ServerException(ApiStatus.INVALID_CAPTCHA);
        return ThrowableUtils.handle(() -> {
            // 2.通过认证管理器进行根据用户名和密码验证
            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getAccount(), loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            // 3.获取认证成功的用户信息
            UserDetail userDetail = (UserDetail) authentication.getPrincipal();
            // 4.生成access_token和refresh_token
            Pair<String, String> pair = jwtUtils.generateToken(userDetail);
            // 5.保存用户信息
            tokenStore.saveUser(pair.getKey(), userDetail);
            return ApiResult.ok(new SysTokenVO(pair.getKey(), pair.getValue()));
        }, () -> ApiResult.error(ApiStatus.BAD_CREDENTIALS));
    }

    @Override
    public ApiResult<SysTokenVO> loginByMobile(SysMobileLoginDTO login) {
        // 1.校验短信验证码是否有效
        // 2.通过认证管理器进行根据手机号和短信验证码验证
        return null;
    }

    @Override
    public ApiResult<Boolean> sendCode(String mobile) {
        SysUserDO user = userMapper.getByMobile(mobile);
        if (user == null) throw new ServerException("用户未注册");
        RandomUtil.randomNumbers(6);
        return null;
    }

    @Override
    public ApiResult<Void> logout(String accessToken) {
        tokenStore.delUser(accessToken);
        return null;
    }
}
