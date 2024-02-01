package com.fly.menu.convert;

import com.fly.common.convert.BaseConvert;
import com.fly.menu.model.domain.SysMenuDO;
import com.fly.menu.model.dto.SysMenuDTO;
import com.fly.menu.model.vo.SysMenuVO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description 数据字典转换器
 * @Author zchengfeng
 * @Date 2023/11/16 14:16
 */
@Mapper(builder = @Builder)
public interface SysMenuConvert extends BaseConvert<SysMenuDO, SysMenuDTO> {
    SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);
    List<SysMenuVO> toMenuVOList(List<SysMenuDO> menus);
}
