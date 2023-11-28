package com.fly.mapper;

import com.fly.model.domain.SysUserDO;
import com.fly.mybatis.mapper.BaseMapper;
import com.mybatisflex.core.query.QueryChain;
import com.mybatisflex.core.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 用户Mapper
 * @Author: zchengfeng
 * @Date: 2023-07-06 15:47:03
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserDO> {
    /**
     * 根据账户查询用户信息
     *
     * @param account 账户
     * @return 用户信息
     */
    default SysUserDO getByAccount(String account) {
        return QueryChain.of(this)
                .select("sys_user.*", "tenant_id")
                .from("sys_user")
                .eq("account", account)
                .one();
    }

    /**
     * 根据手机号查询用户信息
     *
     * @param mobile 手机号
     * @return 用户信息
     */
    default SysUserDO getByMobile(String mobile) {
        return this.selectOneByQuery(new QueryWrapper().eq("mobile", mobile));
    }
}
