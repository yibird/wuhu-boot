package com.fly.org.service.impl;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.impl.BaseServiceImpl;
import com.fly.org.convert.SysOrgConvert;
import com.fly.org.mapper.SysOrgMapper;
import com.fly.org.model.domain.SysOrgDO;
import com.fly.org.model.dto.SysOrgDTO;
import com.fly.org.model.query.SysOrgQuery;
import com.fly.org.service.SysOrgService;
import org.springframework.stereotype.Service;

/**
 * @Description 机构服务实现类
 * @Author zchengfeng
 * @Date 2023/3/14 11:13
 */
@Service
public class SysOrgServiceImpl extends BaseServiceImpl<SysOrgMapper, SysOrgDO, SysOrgDTO> implements SysOrgService {

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
