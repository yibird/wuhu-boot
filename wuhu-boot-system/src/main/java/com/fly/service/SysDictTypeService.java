package com.fly.service;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.BaseService;
import com.fly.model.domain.SysDictTypeDO;
import com.fly.model.dto.SysDictTypeDTO;
import com.fly.model.query.SysDictTypeQuery;

/**
 * @Description 字典分类服务
 * @Author zchengfeng
 * @Date 2023/11/16 11:48
 */
public interface SysDictTypeService extends BaseService<SysDictTypeDO, SysDictTypeDTO> {
    ApiResult<PageResult<SysDictTypeDO>> getList(SysDictTypeQuery query);
}
