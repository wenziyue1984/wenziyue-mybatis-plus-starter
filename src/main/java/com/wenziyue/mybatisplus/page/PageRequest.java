package com.wenziyue.mybatisplus.page;

import lombok.*;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author wenziyue
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest implements Serializable {

    private static final long serialVersionUID = 2176011272499203123L;

    /**
     * 最小起始页
     */
    private static final long MIN_PAGE = 1L;

    /**
     * 最大页数
     */
    private static final long MAX_PAGE = 5000L;

    /**
     * 最小页面大小
     */
    private static final long MIN_SIZE = 10L;

    /**
     * 最大页面大小
     */
    private static final long MAX_SIZE = 200L;


    @Min(value = MIN_SIZE, message = "页面记录数不能小于" + MIN_SIZE)
    @Max(value = MAX_SIZE, message = "页面记录数不能超过" + MAX_SIZE)
    private long size;

    @Min(value = MIN_PAGE, message = "当面页码不能小于" + MIN_PAGE)
    @Max(value = MAX_PAGE, message = "当前页码不能超过" + MAX_PAGE)
    private long current;
}
