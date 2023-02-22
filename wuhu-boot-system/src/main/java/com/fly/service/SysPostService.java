package com.fly.service;

import com.fly.common.model.Result;
import com.fly.model.domain.SysPostDO;
import com.fly.model.domain.SysRoleDO;
import com.fly.mybatis.service.BaseService;

/**
 * @Description SysPostService
 * @Author zchengfeng
 * @Date 2023/2/22 9:24
 */
public interface SysPostService extends BaseService<SysPostDO> {

    Result addSysPost();

    Result delSysPost();

    Result updateSysPost();
}
