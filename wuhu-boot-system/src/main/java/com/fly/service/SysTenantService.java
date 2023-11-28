package com.fly.service;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.BaseService;
import com.fly.model.domain.SysTenantDO;
import com.fly.model.dto.SysTenantDTO;
import com.fly.model.query.SysTenantQuery;

/**
 * @Description 租户服务
 * @Author zchengfeng
 * @Date 2023/11/13 9:24
 */
public interface SysTenantService extends BaseService<SysTenantDO, SysTenantDTO> {
    ApiResult<PageResult<SysTenantDO>> getList(SysTenantQuery query);
}
