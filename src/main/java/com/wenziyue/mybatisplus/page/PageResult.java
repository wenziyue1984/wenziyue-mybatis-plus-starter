package com.wenziyue.mybatisplus.page;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wenziyue
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -3518880765776429275L;

    private List<T> records;

    private long total;

    private long size = 10;

    private long current = 1;

    private long pages;

    /**
     * 换个马甲
     *
     * @param func 转换器
     * @param <U>  新的元素乐星
     * @return 新的分页结果
     */
    public <U> PageResult<U> map(Function<? super T, ? extends U> func) {
        return PageResult.<U>builder().total(total).size(size).current(current).pages(pages)
                .records(records.stream().map(func).collect(Collectors.toList())).build();
    }
}
