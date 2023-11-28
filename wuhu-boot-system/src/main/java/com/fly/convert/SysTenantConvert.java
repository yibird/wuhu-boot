package com.fly.convert;

import com.fly.common.convert.BaseConvert;
import com.fly.model.domain.SysTenantDO;
import com.fly.model.dto.SysTenantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description 租户转换器
 * @Author zchengfeng
 * @Date 2023/11/14 11:16
 */
@Mapper
public interface SysTenantConvert extends BaseConvert<SysTenantDO, SysTenantDTO> {
    SysTenantConvert INSTANCE = Mappers.getMapper(SysTenantConvert.class);
}
