package com.fly.post.service;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.BaseService;
import com.fly.post.model.domain.SysPostDO;
import com.fly.post.model.dto.SysPostDTO;
import com.fly.post.model.query.SysPostQuery;

/**
 * @Description 岗位Service
 * @Author zchengfeng
 * @Date 2023/2/22 9:24
 */
public interface SysPostService extends BaseService<SysPostDO, SysPostDTO> {

    ApiResult<PageResult<SysPostDO>> getList(SysPostQuery query);

}
