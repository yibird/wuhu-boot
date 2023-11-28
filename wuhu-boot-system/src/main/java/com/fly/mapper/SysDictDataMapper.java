package com.fly.mapper;

import com.fly.common.utils.PageUtil;
import com.fly.model.query.SysDictDataQuery;
import com.fly.mybatis.mapper.BaseMapper;
import com.fly.model.domain.SysDictDataDO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 字典数据Mapper
 * @Author: zchengfeng
 * @Date: 2023-07-06 15:47:03
 */
@Mapper
public interface SysDictDataMapper extends BaseMapper<SysDictDataDO> {
    default Page<SysDictDataDO> getList(SysDictDataQuery query) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("dict_type", query.getDictType())
                .like("dict_label", query.getDictLabel());
        return this.paginate(PageUtil.toPage(query), wrapper);
    }
}
