package com.fly.common.model.vo;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class TreeNodeAbstract<T,V> {

    public List<T> children;

    public abstract V getId();

    public abstract V getParentId();

    public abstract void setChildren(List<T> children);

    @Id(keyType = KeyType.Auto)
    @Schema(description = "id")
    protected Long id;

    @Schema(description = "租户id")
    protected Long tenantId;

    @Schema(description = "数据状态(0禁用,1启用)")
    protected Boolean status;

    @Schema(description = "备注")
    protected String remark;

    @Schema(description = "版本号")
    protected Integer version;

    @Schema(description = "排序序号")
    @Range(min = 0, max = 99999999)
    protected Integer sort;

    @Schema(description = "删除标志(0未删除,1已删除)")
    protected Boolean deleted;

    @Schema(description = "创建人")
    @Column
    protected String creator;

    @Schema(description = "创建时间")
    @Column
    protected Date createTime;

    @Schema(description = "修改人")
    @Column
    protected String updater;

    @Schema(description = "修改时间")
    @Column
    protected Date updateTime;
}
