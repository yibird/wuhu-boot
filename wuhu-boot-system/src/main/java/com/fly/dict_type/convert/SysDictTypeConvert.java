package com.fly.dict_type.convert;

import com.fly.common.convert.BaseConvert;
import com.fly.dict_type.model.domain.SysDictTypeDO;
import com.fly.dict_type.model.dto.SysDictTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description 字典类型转换器
 * @Author zchengfeng
 * @Date 2023/11/16 14:16
 */
@Mapper
public interface SysDictTypeConvert extends BaseConvert<SysDictTypeDO, SysDictTypeDTO> {
    SysDictTypeConvert INSTANCE = Mappers.getMapper(SysDictTypeConvert.class);
}
