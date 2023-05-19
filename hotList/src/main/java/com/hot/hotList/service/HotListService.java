package com.hot.hotList.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hot.hotList.model.entity.HotListPO;

import java.util.List;

/**
 * @author jin
 * @date 2021/8/23
 */
public interface HotListService extends IService<HotListPO> {

    /**
     * 获取全部热榜信息
     * @return 热榜信息
     */
    List<HotListPO> queryHotList();

    /**
     * 根据path获取热榜信息
     * @return 热榜信息
     */
    HotListPO queryHotByPath(String path);
}
