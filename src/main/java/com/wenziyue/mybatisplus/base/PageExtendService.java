package com.wenziyue.mybatisplus.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wenziyue.mybatisplus.page.PageRequest;
import com.wenziyue.mybatisplus.page.PageResult;
import lombok.val;

/**
 * @author wenziyue
 */
public interface PageExtendService<T> extends IService<T> {

    /**
     * @param dto          分页请求
     * @param queryWrapper 条件,可以为空
     * @return 分页结果
     */
    default PageResult<T> page(PageRequest dto, Wrapper<T> queryWrapper) {
        val p1 = PageDTO.<T>of(dto.getCurrent(), dto.getSize());
        val result = page(p1, queryWrapper != null ? queryWrapper : Wrappers.emptyWrapper());
        return PageResult.<T>builder()
                .records(result.getRecords())
                .size(result.getSize())
                .pages(result.getPages())
                .current(result.getCurrent())
                .total(result.getTotal())
                .build();
    }
}
