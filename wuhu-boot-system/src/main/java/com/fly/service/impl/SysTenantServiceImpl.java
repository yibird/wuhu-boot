package com.fly.service.impl;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.impl.BaseServiceImpl;
import com.fly.convert.SysTenantConvert;
import com.fly.mapper.SysTenantMapper;
import com.fly.model.domain.SysTenantDO;
import com.fly.model.dto.SysTenantDTO;
import com.fly.model.query.SysTenantQuery;
import com.fly.service.SysTenantService;
import org.springframework.stereotype.Service;

/**
 * @Description: 租户服务实现类
 * @Author: zchengfeng
 * @Date: 2023-11-15 15:47:03
 */
@Service
public class SysTenantServiceImpl extends BaseServiceImpl<SysTenantMapper, SysTenantDO, SysTenantDTO> implements SysTenantService {

    private final SysTenantMapper tenantMapper;

    public SysTenantServiceImpl(SysTenantMapper tenantMapper) {
        super(SysTenantConvert.INSTANCE::toSource);
        this.tenantMapper = tenantMapper;
    }

    @Override
    public ApiResult<PageResult<SysTenantDO>> getList(SysTenantQuery query) {
        return ApiResult.ok(tenantMapper.getList(query));
    }
}
