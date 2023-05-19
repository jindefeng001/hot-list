package com.hot.hotList.model.entity;

import lombok.Data;

import java.util.List;

/**
 * @author jin
 * @date 2021/8/23
 */
@Data
public class HotListPO {

    private static final long serialVersionUID = 1L;

    /**
     * 网站标识
     */
    private String key;
    /**
     * 内容
     */
    private List<HotListDetailPO> listDetail;
    
}
