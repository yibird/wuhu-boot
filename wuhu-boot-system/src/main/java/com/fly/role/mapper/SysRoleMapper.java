package com.fly.role.mapper;

import com.fly.common.utils.PageUtil;
import com.fly.model.domain.SysRoleDO;
import com.fly.model.query.SysRoleQuery;
import com.fly.mybatis.mapper.BaseMapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 角色Mapper
 * @Author zchengfeng
 * @Date: 2023-02-12 14:47:03
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRoleDO> {

    default Page<SysRoleDO> getList(SysRoleQuery query) {
        QueryWrapper wrapper = new QueryWrapper()
                .like("role_code", query.getRoleCode())
                .like("role_name", query.getRoleName());
        return this.paginate(PageUtil.toPage(query), wrapper);
    }
}
