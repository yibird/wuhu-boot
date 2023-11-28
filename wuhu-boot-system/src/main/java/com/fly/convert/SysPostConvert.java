package com.fly.convert;

import com.fly.common.convert.BaseConvert;
import com.fly.model.domain.SysPostDO;
import com.fly.model.dto.SysPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description SysPostConvert
 * @Author zchengfeng
 * @Date 2023/6/6 11:16
 */
@Mapper
public interface SysPostConvert extends BaseConvert<SysPostDO, SysPostDTO> {
    SysPostConvert INSTANCE = Mappers.getMapper(SysPostConvert.class);
}
