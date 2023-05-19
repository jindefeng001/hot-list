package com.hot.commonUtils.core;

import lombok.Data;

import java.util.List;

/**
 * @author jin
 * @date 2021/8/8
 */
@Data
public class SysPageResult<T> {

    private Long total;

    private List<T> data;

    public SysPageResult(List<T> data, Long total) {
        this.data = data;
        this.total = total;
    }
}
