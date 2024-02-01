package com.fly.dict_data.service.impl;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.impl.BaseServiceImpl;
import com.fly.dict_data.convert.SysDictDataConvert;
import com.fly.dict_data.mapper.SysDictDataMapper;
import com.fly.dict_data.model.domain.SysDictDataDO;
import com.fly.dict_data.model.dto.SysDictDataDTO;
import com.fly.dict_data.model.query.SysDictDataQuery;
import com.fly.dict_data.service.SysDictDataService;
import org.springframework.stereotype.Service;


/**
 * @Description 数据字典服务
 * @Author zchengfeng
 * @Date 2023/11/16 11:48
 */
@Service
public class SysDictDataServiceImpl extends BaseServiceImpl<SysDictDataMapper, SysDictDataDO, SysDictDataDTO>
        implements SysDictDataService {

    public SysDictDataServiceImpl() {
        super(SysDictDataConvert.INSTANCE::toSource);
    }

    @Override
    public ApiResult<PageResult<SysDictDataDO>> getList(SysDictDataQuery query) {
        return null;
    }
}
