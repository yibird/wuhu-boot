package com.fly.system.model.domain;

import com.fly.common.model.BaseDO;
import lombok.Data;

/**
 * @Description: 部门DO
 * @Author: zchengfeng
 * @Date: 2023-02-12 14:29:49
 */
@Data
public class SysDeptDO extends BaseDO {
    private Long id;
    private Long parentId;
    private String ancestors;
    private String deptName;
    private String phone;
    private String email;
    private String leader;
    private String leaderPhone;
    private Integer status;
}
