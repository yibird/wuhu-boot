package com.fly.org.service;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.BaseService;
import com.fly.org.model.domain.SysOrgDO;
import com.fly.org.model.dto.SysOrgDTO;
import com.fly.org.model.query.SysOrgQuery;

/**
 * @Description 机构服务
 * @Author zchengfeng
 * @Date 2023/3/14 11:12
 */
public interface SysOrgService extends BaseService<SysOrgDO, SysOrgDTO> {
    ApiResult<PageResult<SysOrgDO>> getList(SysOrgQuery query);
}
