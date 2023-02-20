package com.fly.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fly.common.model.BaseDO;
import com.fly.model.domain.SysRoleDO;
import com.fly.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 角色Mapper
 * @Author: zchengfeng
 * @Date: 2023-02-12 14:47:03
 */
@Mapper
public interface SysRoleMapper<S extends BaseDO> extends BaseMapper<SysRoleDO> {
    default List<SysRoleDO> getRoles() {
        return this.selectList(new QueryWrapper());
    }
}
