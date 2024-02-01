package com.fly.tenant.service.impl;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.impl.BaseServiceImpl;
import com.fly.tenant.convert.SysTenantConvert;
import com.fly.tenant.mapper.SysTenantMapper;
import com.fly.tenant.model.domain.SysTenantDO;
import com.fly.tenant.model.dto.SysTenantDTO;
import com.fly.tenant.service.SysTenantService;
import org.springframework.stereotype.Service;

/**
 * @Description 租户服务实现类
 * @Author zchengfeng
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
    public ApiResult<PageResult<SysTenantDO>> getList(com.fly.tenant.model.query.SysTenantQuery query) {
        return ApiResult.ok(tenantMapper.getList(query));
    }
}
