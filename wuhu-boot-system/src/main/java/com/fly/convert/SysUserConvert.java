package com.fly.convert;

import com.fly.common.convert.BaseConvert;
import com.fly.model.domain.SysUserDO;
import com.fly.model.dto.SysUserDTO;
import com.fly.user.UserDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @Description: 用户模型转换器
 * @Author: zchengfeng
 * @Date: 2023-02-12 15:14:51
 */
@Mapper
public interface SysUserConvert extends BaseConvert<SysUserDO, SysUserDTO> {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "account", target = "username")
    @Mapping(source = "password", target = "password")
    UserDetail convertUserDetail(SysUserDO sysUserDO);
}
