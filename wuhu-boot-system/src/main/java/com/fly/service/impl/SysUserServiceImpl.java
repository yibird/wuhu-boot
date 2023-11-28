package com.fly.service.impl;

import com.fly.common.model.response.ApiResult;
import com.fly.common.service.impl.BaseServiceImpl;
import com.fly.convert.SysUserConvert;
import com.fly.mapper.SysUserMapper;
import com.fly.model.domain.SysUserDO;
import com.fly.model.dto.SysUserDTO;
import com.fly.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUserDO, SysUserDTO>
        implements SysUserService {

    private final SysUserMapper userMapper;

    public SysUserServiceImpl(SysUserMapper userMapper) {
        super(SysUserConvert.INSTANCE::toSource);
        this.userMapper = userMapper;
    }

    @Transactional
    @Override
    public ApiResult<Void> register(String account, String password) {
        SysUserDO sysUserDO = userMapper.getByAccount(account);
        if (sysUserDO != null) return ApiResult.okWithMessage("账号已被注册,请重新输入账号!");
        int row = userMapper.insert(new SysUserDO().setAccount(account).setPhone(password));
        return ApiResult.okWithMessage(row > 0 ? "注册成功" : "注册失败");
    }
}
