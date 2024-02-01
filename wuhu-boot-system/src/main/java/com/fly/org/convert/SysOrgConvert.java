package com.fly.org.convert;

import com.fly.common.convert.BaseConvert;
import com.fly.org.model.domain.SysOrgDO;
import com.fly.org.model.dto.SysOrgDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description 机构转换器
 * @Author zchengfeng
 * @Date 2023/3/14 11:16
 */
@Mapper
public interface SysOrgConvert extends BaseConvert<SysOrgDO, SysOrgDTO> {
    SysOrgConvert INSTANCE = Mappers.getMapper(SysOrgConvert.class);
}
