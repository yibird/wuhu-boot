package com.fly.service.impl;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.impl.BaseServiceImpl;
import com.fly.convert.SysDictTypeConvert;
import com.fly.mapper.SysDictTypeMapper;
import com.fly.model.domain.SysDictTypeDO;
import com.fly.model.dto.SysDictTypeDTO;
import com.fly.model.query.SysDictTypeQuery;
import com.fly.service.SysDictTypeService;
import org.springframework.stereotype.Service;

/**
 * @Description 字典分类服务实现类
 * @Author zchengfeng
 * @Date 2023/11/16 11:48
 */
@Service
public class SysDictTypeServiceImpl extends
        BaseServiceImpl<SysDictTypeMapper, SysDictTypeDO, SysDictTypeDTO>
        implements SysDictTypeService {

    private final SysDictTypeMapper dictTypeMapper;

    public SysDictTypeServiceImpl(SysDictTypeMapper dictTypeMapper) {
        super(SysDictTypeConvert.INSTANCE::toSource);
        this.dictTypeMapper = dictTypeMapper;
    }

    @Override
    public ApiResult<PageResult<SysDictTypeDO>> getList(SysDictTypeQuery query) {
        return ApiResult.ok(dictTypeMapper.getList(query));
    }

}
