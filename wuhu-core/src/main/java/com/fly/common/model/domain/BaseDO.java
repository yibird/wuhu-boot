package com.fly.common.model.domain;


import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.core.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 基础实体类, 包含了实体类通用字段
 * @Author: zchengfeng
 * @Data: 2022/12/6 16:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDO<T extends Model<T>> extends Model<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -3150754858878768418L;

    @Id(keyType = KeyType.Auto)
    @Schema(description = "id")
    private Integer id;

    @Schema(description = "租户id")
    @Column(tenantId = true)
    private Integer tenantId;

    @Schema(description = "数据状态(0禁用,1启用)")
    private Boolean status;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "版本号")
    private Integer version;

    @Schema(description = "排序序号")
    @Range(min = 0, max = 99999999)
    private Integer sort;

    @Schema(description = "删除标志(0未删除,1已删除)")
    private Boolean deleted;

    @Schema(description = "创建人")
    @Column
    private String creator;

    @Schema(description = "创建时间")
    @Column
    private Date createTime;

    @Schema(description = "修改人")
    @Column
    private String updater;

    @Schema(description = "修改时间")
    @Column
    private Date updateTime;
}
