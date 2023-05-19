package com.hot.hotList.model.entity;

import lombok.Data;

/**
 * @author jin
 * @date 2021/8/23
 */
@Data
public class HotListDetailVO {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;
    /**
     * 链接
     */
    private String url;
}
