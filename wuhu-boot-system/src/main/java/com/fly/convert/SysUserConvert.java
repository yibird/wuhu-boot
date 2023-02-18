package com.fly.convert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description:用户模型转换器
 * @Author: zchengfeng
 * @Date: 2023-02-12 15:14:51
 */
@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);
}
