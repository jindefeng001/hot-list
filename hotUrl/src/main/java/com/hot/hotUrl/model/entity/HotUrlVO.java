package com.hot.hotUrl.model.entity;

import com.hot.commonUtils.core.PageQueryVO;
import lombok.Data;

/**
 * @author jin
 * @date 2021/8/13
 */
@Data
public class HotUrlVO extends PageQueryVO {

    private static final long serialVersionUID = 1L;

    /**
     * 主键标识
     */
    private Long id;
    /**
     * 网站标识
     */
    private String pathName;
    /**
     * 网站名称
     */
    private String name;
    /**
     * 网址链接
     */
    private String url;
    /**
     * 抽取CSS
     */
    private String cssPath;
    /**
     * 首页CSS
     */
    private String homeCssPath;
    /**
     * 是否使用
     */
    private Integer isUse;
    /**
     * 是否删除
     */
    private Integer isDel;
    /**
     * 乐观锁
     */
    private Integer version;
    
}
