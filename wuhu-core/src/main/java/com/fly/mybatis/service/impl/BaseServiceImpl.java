package com.fly.mybatis.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fly.mybatis.service.BaseService;

/**
 * @Description: 基础服务实现类,所有service类都需要实现该类
 * @Author: zchengfeng
 * @Date: 2023-02-12 22:26:45
 */
public class BaseServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M, T> implements BaseService<T> {
}
