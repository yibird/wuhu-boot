package com.fly.dict_type.service;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.BaseService;
import com.fly.dict_type.model.domain.SysDictTypeDO;
import com.fly.dict_type.model.dto.SysDictTypeDTO;
import com.fly.dict_type.model.query.SysDictTypeQuery;

/**
 * @Description 字典分类服务
 * @Author zchengfeng
 * @Date 2023/11/16 11:48
 */
public interface SysDictTypeService extends BaseService<SysDictTypeDO, SysDictTypeDTO> {
    ApiResult<PageResult<SysDictTypeDO>> getList(SysDictTypeQuery query);
}
