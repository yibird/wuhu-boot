package com.fly.menu.service;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.BaseService;
import com.fly.menu.model.domain.SysMenuDO;
import com.fly.menu.model.dto.SysMenuDTO;
import com.fly.menu.model.query.SysMenuQuery;
import com.fly.menu.model.vo.SysMenuVO;

import java.util.List;
import java.util.Set;

/**
 * @Description 菜单服务
 * @Author zchengfeng
 * @Date 2023/7/3 15:48
 */
public interface SysMenuService extends BaseService<SysMenuDO, SysMenuDTO> {

    ApiResult<List<SysMenuVO>> getMenuTree(Long userId);

    ApiResult<PageResult<SysMenuDO>> getList(SysMenuQuery query);

    /**
     * 根据用户信息查询对应的权限列表
     *
     * @param userId 用户id
     * @return 权限列表
     */
    Set<String> getUserAuthoritySet(long userId);
}
