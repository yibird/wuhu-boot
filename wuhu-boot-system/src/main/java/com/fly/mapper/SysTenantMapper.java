package com.fly.mapper;

import com.fly.common.utils.PageUtil;
import com.fly.model.domain.SysTenantDO;
import com.fly.model.query.SysTenantQuery;
import com.fly.mybatis.mapper.BaseMapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 租户Mapper
 * @Author: zchengfeng
 * @Date: 2023-07-06 15:47:03
 */
@Mapper
public interface SysTenantMapper extends BaseMapper<SysTenantDO> {
    default Page<SysTenantDO> getList(SysTenantQuery query) {
        QueryWrapper wrapper = new QueryWrapper()
                .like("tenant_code", query.getTenantCode())
                .like("tenant_name", query.getTenantName());
        return this.paginate(PageUtil.toPage(query), wrapper);
    }
}
