package com.fly.service.impl;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.impl.BaseServiceImpl;
import com.fly.mapper.SysPostMapper;
import com.fly.model.domain.SysPostDO;
import com.fly.model.dto.SysPostDTO;
import com.fly.convert.SysPostConvert;
import com.fly.model.query.SysPostQuery;
import com.fly.service.SysPostService;
import org.springframework.stereotype.Service;

/**
 * @Description 岗位服务实现类
 * @Author zchengfeng
 * @Date 2023/2/22 9:24
 */
@Service
public class SysPostServiceImpl extends BaseServiceImpl<SysPostMapper, SysPostDO, SysPostDTO> implements SysPostService {

    private final SysPostMapper postMapper;

    public SysPostServiceImpl(SysPostMapper postMapper) {
        super(SysPostConvert.INSTANCE::toSource);
        this.postMapper = postMapper;
    }

    @Override
    public ApiResult<PageResult<SysPostDO>> getList(SysPostQuery query) {
        return ApiResult.ok(postMapper.getList(query));
    }
}
