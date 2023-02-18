package com.fly.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: 基础实体类,包含了实体类通用字段
 * @Author: zchengfeng
 * @Data: 2022/12/6 16:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDO {
    private Integer orderNum;
    private String remark;
    private Integer delFlag;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}
