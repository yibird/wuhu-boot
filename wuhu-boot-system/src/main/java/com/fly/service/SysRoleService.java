package com.fly.service;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.model.domain.SysRoleDO;
import com.fly.model.dto.SysRoleDTO;
import com.fly.model.query.SysRoleQuery;
import com.fly.common.service.BaseService;

/**
 * @Description 角色服务
 * @Author zchengfeng
 * @Date 2023/7/3 15:48
 */
public interface SysRoleService extends BaseService<SysRoleDO, SysRoleDTO> {

    ApiResult<PageResult<SysRoleDO>> getList(SysRoleQuery query);

}
