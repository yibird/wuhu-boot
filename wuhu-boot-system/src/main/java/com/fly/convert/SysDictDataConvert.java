package com.fly.convert;

import com.fly.common.convert.BaseConvert;
import com.fly.model.domain.SysDictDataDO;
import com.fly.model.dto.SysDictDataDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description 数据字典转换器
 * @Author zchengfeng
 * @Date 2023/11/16 14:16
 */
@Mapper
public interface SysDictDataConvert extends BaseConvert<SysDictDataDO, SysDictDataDTO> {
    SysDictDataConvert INSTANCE = Mappers.getMapper(SysDictDataConvert.class);
}
