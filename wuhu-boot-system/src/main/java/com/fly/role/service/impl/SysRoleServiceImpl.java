package com.fly.role.service.impl;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.impl.BaseServiceImpl;
import com.fly.convert.SysRoleConvert;
import com.fly.mapper.SysRoleMapper;
import com.fly.model.domain.SysRoleDO;
import com.fly.model.query.SysRoleQuery;
import com.fly.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * @Description 角色服务实现类
 * @Author zchengfeng
 * @Date 2023/11/15 17:55
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRoleDO, SysRoleDTO> implements SysRoleService {

    private final SysRoleMapper roleMapper;

    public SysRoleServiceImpl(SysRoleMapper roleMapper) {
        super(SysRoleConvert.INSTANCE::toSource);
        this.roleMapper = roleMapper;
    }

    @Override
    public ApiResult<PageResult<SysRoleDO>> getList(SysRoleQuery query) {
        return ApiResult.ok(roleMapper.getList(query));
    }
}
