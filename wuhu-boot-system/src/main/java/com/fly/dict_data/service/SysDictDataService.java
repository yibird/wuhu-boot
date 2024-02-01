package com.fly.dict_data.service;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.BaseService;
import com.fly.dict_data.model.domain.SysDictDataDO;
import com.fly.dict_data.model.dto.SysDictDataDTO;
import com.fly.dict_data.model.query.SysDictDataQuery;

/**
 * @Description 数据字典服务
 * @Author zchengfeng
 * @Date 2023/11/16 11:48
 */
public interface SysDictDataService extends BaseService<SysDictDataDO, SysDictDataDTO> {
    ApiResult<PageResult<SysDictDataDO>> getList(SysDictDataQuery query);
}
