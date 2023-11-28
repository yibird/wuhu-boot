package com.fly.mapper;

import com.fly.common.utils.PageUtil;
import com.fly.model.query.SysDictTypeQuery;
import com.fly.mybatis.mapper.BaseMapper;
import com.fly.model.domain.SysDictTypeDO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 字典类型DO
 * @Author: zchengfeng
 * @Date: 2023-07-05 15:42:18
 */
@Mapper
public interface SysDictTypeMapper extends BaseMapper<SysDictTypeDO> {

    default Page<SysDictTypeDO> getList(SysDictTypeQuery query) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("dict_code", query.getDictCode())
                .like("dict_name", query.getDictName())
                .eq("dict_source", query.getDictSource());
        return this.paginate(PageUtil.toPage(query), wrapper);
    }
}
