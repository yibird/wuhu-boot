package com.fly.post.mapper;

import com.fly.common.utils.PageUtil;
import com.fly.mybatis.mapper.BaseMapper;
import com.fly.post.model.domain.SysPostDO;
import com.fly.post.model.query.SysPostQuery;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Description SysPostMapper
 * @Author zchengfeng
 * @Date 2023/2/22 9:20
 */
@Mapper
public interface SysPostMapper extends BaseMapper<SysPostDO> {

    default Page<SysPostDO> getList(SysPostQuery query) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("post_name", query.getPostName())
                .like("post_code", query.getPostCode())
                .eq("post_type", query.getPostType())
                .eq("post_level", query.getPostLevel());
        return this.paginate(PageUtil.toPage(query), wrapper);
    }
}
