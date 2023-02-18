package com.fly.model.domain;

import com.fly.common.model.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 用户DO
 * @Author: zchengfeng
 * @Date: 2023-02-12 15:38:10
 * @param: null
 * @return: null
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserDO extends BaseDO {
    private Long id;
    private Long deptId;
    private String account;
    private String nickname;
    private int userType;
    private int sex;
    private int age;
    private String phone;
    private String email;
    private String idCard;
    private String address;
    private int status;
}
