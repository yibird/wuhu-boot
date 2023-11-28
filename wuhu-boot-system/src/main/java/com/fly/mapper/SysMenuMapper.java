package com.fly.mapper;

import com.fly.common.utils.PageUtil;
import com.fly.model.query.SysMenuQuery;
import com.fly.mybatis.mapper.BaseMapper;
import com.fly.model.domain.SysMenuDO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryChain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @Description: 菜单Mapper
 * @Author: zchengfeng
 * @Date: 2023-07-06 15:47:03
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuDO> {

    /**
     * 根据用户id查询对应菜单集合
     *
     * @param userId 用户id
     * @return 菜单集合
     */
    List<SysMenuDO> getListByUserId(@Param("userId") Long userId);

    default Page<SysMenuDO> getList(SysMenuQuery query) {
        QueryChain<SysMenuDO> chain = QueryChain.of(this)
                .eq("p_id", query.getPId())
                .like("menu_code", query.getMenuCode())
                .like("menu_name", query.getMenuName())
                .eq("menu_type", query.getMenuType());
        return this.paginate(PageUtil.toPage(query), chain);
    }

    /**
     * 根据用户id查询对应权限列表
     *
     * @param userId 用户id
     * @return 用户权限列表
     */
    Set<String> getUserAuthoritySet(@Param("userId") Long userId);
}
