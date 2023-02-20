package com.fly;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fly.common.model.BaseDO;
import com.fly.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ServerApplication.class)
public class RunTest {
    @Autowired
    SysRoleMapper<BaseDO> sysRoleMapper;

    @Test
    public void sss() {
        System.out.println("asdasdasd");
        System.out.println("sysRoleMapper:"+sysRoleMapper.selectList(new QueryWrapper()));
    }
}
