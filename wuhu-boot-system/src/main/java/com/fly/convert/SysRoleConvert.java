package com.fly.convert;

import com.fly.common.convert.BaseConvert;
import com.fly.model.domain.SysRoleDO;
import com.fly.model.dto.SysRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: 角色模型转换器
 * @Author: zchengfeng
 * @Date: 2023-02-12 15:14:51
 */
@Mapper
public interface SysRoleConvert extends BaseConvert<SysRoleDO, SysRoleDTO> {
    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);
}
