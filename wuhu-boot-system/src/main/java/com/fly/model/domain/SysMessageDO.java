package com.fly.model.domain;

import com.fly.common.model.domain.BaseDO;
import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: 消息DO
 * @Author: zchengfeng
 * @Date: 2023-07-06 10:42:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "消息DO")
@Table("sys_message")
public class SysMessageDO extends BaseDO {
    @Schema(description = "消息类型(1:通知公告,2:系统消息)")
    private Integer type;
    @Schema(description = "消息标题")
    private String title;
    @Schema(description = "过期时间")
    private Date expiration;
    @Schema(description = "接收者类型(1:指定用户,2:全体用户)")
    private Integer receiverType;
    @Schema(description = "接收者id集合,以逗号分割,仅在接收者类型为1时生效")
    private String receivers;
    @Schema(description = "优先级(0:高,1:中,2:低)")
    private Integer priority;
    @Schema(description = "消息内容")
    private String content;
    @Schema(description = "撤销时间")
    private Date cancel_time;
    @Schema(description = "消息状态(0:草稿,1:已发送,2:已接收,3:已查阅)")
    private Integer messageStatus;
}
