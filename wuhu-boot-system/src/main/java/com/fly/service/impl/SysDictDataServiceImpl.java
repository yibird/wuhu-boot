package com.fly.service.impl;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.impl.BaseServiceImpl;
import com.fly.convert.SysDictDataConvert;
import com.fly.mapper.SysDictDataMapper;
import com.fly.model.domain.SysDictDataDO;
import com.fly.model.dto.SysDictDataDTO;
import com.fly.model.query.SysDictDataQuery;
import com.fly.service.SysDictDataService;
import org.springframework.stereotype.Service;


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
