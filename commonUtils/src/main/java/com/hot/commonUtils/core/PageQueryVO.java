package com.hot.commonUtils.core;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jin
 * @date 2021/8/13
 */
@Data
public class PageQueryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页
     */
    private Integer pageNum;
    /**
     * 每页的数量
     */
    private Integer pageSize;
}
