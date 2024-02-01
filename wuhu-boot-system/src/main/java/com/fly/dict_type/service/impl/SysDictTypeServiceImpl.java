package com.fly.dict_type.service.impl;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.impl.BaseServiceImpl;
import com.fly.dict_type.convert.SysDictTypeConvert;
import com.fly.dict_type.mapper.SysDictTypeMapper;
import com.fly.dict_type.model.domain.SysDictTypeDO;
import com.fly.dict_type.model.dto.SysDictTypeDTO;
import com.fly.dict_type.model.query.SysDictTypeQuery;
import com.fly.dict_type.service.SysDictTypeService;
import org.springframework.stereotype.Service;

/**
 * @Description 字典分类服务实现类
 * @Author zchengfeng
 * @Date 2023/11/16 11:48
 */
@Service
public class SysDictTypeServiceImpl extends BaseServiceImpl<SysDictTypeMapper, SysDictTypeDO, SysDictTypeDTO> implements SysDictTypeService {

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
