package com.fly.service.impl;

import com.fly.common.model.Result;
import com.fly.mapper.SysPostMapper;
import com.fly.model.domain.SysPostDO;
import com.fly.mybatis.service.impl.BaseServiceImpl;
import com.fly.service.SysPostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description SysPost服务实现类
 * @Author zchengfeng
 * @Date 2023/2/22 9:24
 */
@Service
@AllArgsConstructor
public class SysPostServiceImpl extends BaseServiceImpl<SysPostMapper, SysPostDO> implements SysPostService {
    private final SysPostMapper sysPostMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addSysPost() {
        return Result.of(sysPostMapper.add() > 0, "添加成功", "添加失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delSysPost() {
        return Result.of(sysPostMapper.add() > 0, "删除成功", "删除失败");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result updateSysPost() {
        return Result.of(sysPostMapper.add() > 0, "修改成功", "修改失败");
    }
}
