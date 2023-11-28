package com.fly.common.model.response;

import com.mybatisflex.core.paginate.Page;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class PageResult<T> {

    // 总条数
    private long total;
    // 数据列表
    private List<T> list;
    // 当前页码
    private long current;
    // 显示条数
    private long pageSize;

    public static <T> PageResult<T> of() {
        return PageResult.<T>builder().build();
    }

    public static <T> PageResult<T> of(long total, List<T> list) {
        return PageResult.<T>builder()
                .total(total)
                .build();
    }

    public static <T> PageResult<T> of(Page<T> page) {
        if (page != null) {
            return PageResult.<T>builder().current(page.getPageNumber())
                    .pageSize(page.getPageSize())
                    .total(page.getTotalRow())
                    .list(page.getRecords())
                    .build();
        }
        return of();
    }
}