package com.fly.service.impl;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.impl.BaseServiceImpl;
import com.fly.mapper.SysOrgMapper;
import com.fly.model.domain.SysOrgDO;
import com.fly.model.dto.SysOrgDTO;
import com.fly.model.query.SysOrgQuery;
import com.fly.convert.SysOrgConvert;
import com.fly.service.SysOrgService;
import org.springframework.stereotype.Service;

/**
 * @Description 机构服务实现类
 * @Author zchengfeng
 * @Date 2023/3/14 11:13
 */
@Service
public class SysOrgServiceImpl extends
        BaseServiceImpl<SysOrgMapper, SysOrgDO, SysOrgDTO>
        implements SysOrgService {

    private final SysOrgMapper orgMapper;

    public SysOrgServiceImpl(SysOrgMapper orgMapper) {
        super(SysOrgConvert.INSTANCE::toSource);
        this.orgMapper = orgMapper;
    }

    @Override
    public ApiResult<PageResult<SysOrgDO>> getList(SysOrgQuery query) {
        return ApiResult.ok(orgMapper.getList(query));
    }

}
