package com.fly.system.model.domain;

import com.fly.common.model.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 职位DO
 * @Author: zchengfeng
 * @Date: 2023-02-12 15:41:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPostDO extends BaseDO {
    private Long id;
    private String postCode;
    private String postName;
    private int status;
}
