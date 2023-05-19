package com.hot.hotUrl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hot.hotUrl.model.entity.HotUrlPO;
import com.hot.hotUrl.model.entity.HotUrlVO;

import java.util.List;

/**
 * @author jin
 * @date 2021/8/13
 */
public interface HotUrlService extends IService<HotUrlPO> {

    /**
     * 查询全部链接-不分页-已启用
     * @return 爬虫对应链接
     */
    List<HotUrlPO> queryAll();

    /**
     * 查询全部链接-分页
     * @param hotUrlVO 查询参数
     * @return 爬虫对应链接
     */
    IPage<HotUrlVO> queryAllForPage(HotUrlVO hotUrlVO);

    /**
     * 查询链接详情
     * @param id 链接实体类主键
     * @return 链接实体类
     */
    HotUrlPO queryUrlById(String id);
    
    
}
