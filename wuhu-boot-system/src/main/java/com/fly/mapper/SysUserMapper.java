package com.fly.mapper;

import com.fly.model.domain.SysUserDO;
import com.fly.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserDO> {
}
