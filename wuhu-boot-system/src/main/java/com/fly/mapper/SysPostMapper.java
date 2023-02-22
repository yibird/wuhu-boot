package com.fly.mapper;

import com.fly.model.domain.SysPostDO;
import com.fly.model.domain.SysRoleDO;
import com.fly.mybatis.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description SysPostMapper
 * @Author zchengfeng
 * @Date 2023/2/22 9:20
 */
@Mapper
public interface SysPostMapper extends BaseMapper<SysPostDO> {
    int add();

    int post();

    int update();
}
