package com.fly.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description:角色模型转换器
 * @Author: zchengfeng
 * @Date: 2023-02-12 15:14:51
 * @param: null
 * @return: null
 */
@Mapper
public interface SysRoleConvert {

    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);
}
