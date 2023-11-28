package com.fly.model.domain;

import com.fly.common.model.domain.BaseDO;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table("sys_user_login_record")
@Schema(name = "用户登录记录DO模型")
public class SysUserLoginRecordDO extends BaseDO {

}
