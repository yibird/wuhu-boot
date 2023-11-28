package com.fly.common.service.impl;

import com.fly.common.model.domain.BaseDO;
import com.fly.common.model.dto.BaseDTO;
import com.fly.common.model.response.ApiResult;
import com.fly.common.service.BaseService;
import com.fly.mybatis.mapper.BaseMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

public class BaseServiceImpl<M extends BaseMapper<DO>, DO extends BaseDO<DO>, DTO extends BaseDTO> extends ServiceImpl<M, DO> implements BaseService<DO, DTO> {
    private final Function<DTO, DO> dtoToDoFunc;

    //    private final Function<DO, DTO> toTargetFunc;
    public BaseServiceImpl(Function<DTO, DO> dtoToDoFunc) {
        this.dtoToDoFunc = dtoToDoFunc;
    }
//    public IBaseServiceImpl(Function<DTO, DO> dtoToDoFunc, Function<DO, DTO> toTargetFunc) {
//        this.dtoToDoFunc = dtoToDoFunc;
//        this.toTargetFunc = toTargetFunc;
//    }

    @Transactional
    @Override
    public ApiResult<Void> save(DTO dto) {
        if (dtoToDoFunc == null) return ApiResult.error("转换函数不能为空");
        return ApiResult.save(super.save(dtoToDoFunc.apply(dto)));
    }

    @Transactional
    @Override
    public ApiResult<Void> update(DTO dto) {
        if (dtoToDoFunc == null) return ApiResult.error("转换函数不能为空");
        return ApiResult.update(this.updateById(dtoToDoFunc.apply(dto)));
    }

    @Transactional
    @Override
    public ApiResult<Void> del(List<Long> ids) {
        return ApiResult.del(this.removeByIds(ids));
    }

    @Override
    public ApiResult<DO> getInfo(Long id) {
        return ApiResult.ok(this.getById(id));
    }
}
