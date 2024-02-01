package com.fly.menu.service.impl;

import com.fly.common.model.response.ApiResult;
import com.fly.common.model.response.PageResult;
import com.fly.common.service.impl.BaseServiceImpl;
import com.fly.common.utils.TreeUtils;
import com.fly.menu.convert.SysMenuConvert;
import com.fly.menu.mapper.SysMenuMapper;
import com.fly.menu.model.domain.SysMenuDO;
import com.fly.menu.model.dto.SysMenuDTO;
import com.fly.menu.model.query.SysMenuQuery;
import com.fly.menu.model.vo.SysMenuVO;
import com.fly.menu.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Description 菜单服务
 * @Author zchengfeng
 * @Date 2023/7/3 15:48
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper, SysMenuDO, SysMenuDTO>
        implements SysMenuService {
    private final SysMenuMapper menuMapper;

    public SysMenuServiceImpl(SysMenuMapper menuMapper) {
        super(SysMenuConvert.INSTANCE::toSource);
        this.menuMapper = menuMapper;
    }

    @Override
    public ApiResult<List<SysMenuVO>> getMenuTree(Long userId) {
        List<SysMenuVO> menus = SysMenuConvert.INSTANCE.toMenuVOList(menuMapper.getListByUserId(userId));
        List<SysMenuVO> menuTree = TreeUtils.toTree(menus, menu -> menu.getPId().equals(0L));
        return ApiResult.ok(menuTree);
    }

    @Override
    public ApiResult<PageResult<SysMenuDO>> getList(SysMenuQuery query) {
        return ApiResult.ok(menuMapper.getList(query));
    }


    @Override
    public Set<String> getUserAuthoritySet(long userId) {
        return menuMapper.getUserAuthoritySet(userId);
    }
}
