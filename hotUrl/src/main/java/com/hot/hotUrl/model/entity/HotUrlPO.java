package com.hot.hotUrl.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author jin
 * @date 2021/8/12
 */
@TableName("hot_url")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class HotUrlPO {

    private static final long serialVersionUID = 1L;

    /**
     * 主键标识
     */
    @TableId(value = "ID")
    @JsonSerialize(using = ToStringSerializer.class)
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
    @TableLogic
    private Integer isDel;
}
