package com.fly.mapper;

import com.fly.common.utils.PageUtil;
import com.fly.model.query.SysOrgQuery;
import com.fly.mybatis.mapper.BaseMapper;
import com.fly.model.domain.SysOrgDO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 机构Mapper
 * @Author: zchengfeng
 * @Date: 2023-07-06 15:47:03
 */
@Mapper
public interface SysOrgMapper extends BaseMapper<SysOrgDO> {
    /**
     * 根据条件查询列表
     *
     * @param query SysOrgQuery
     * @return 角色列表
     */
    default Page<SysOrgDO> getList(SysOrgQuery query) {
        QueryWrapper wrapper = new QueryWrapper();
        return this.paginate(PageUtil.toPage(query), wrapper);
    }
}
