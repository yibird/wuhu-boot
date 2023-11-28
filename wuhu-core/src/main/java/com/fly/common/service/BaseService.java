package com.fly.common.service;

import com.fly.common.model.domain.BaseDO;
import com.fly.common.model.dto.BaseDTO;
import com.fly.common.model.response.ApiResult;
import com.mybatisflex.core.service.IService;

import java.util.List;

public interface BaseService<DO extends BaseDO<DO>, DTO extends BaseDTO> extends IService<DO> {

    ApiResult<Void> save(DTO dto);

    ApiResult<Void> update(DTO dto);

    ApiResult<Void> del(List<Long> ids);

    ApiResult<DO> getInfo(Long id);
}
