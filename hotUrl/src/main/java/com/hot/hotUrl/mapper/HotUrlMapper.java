package com.hot.hotUrl.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hot.hotUrl.model.entity.HotUrlPO;
import com.hot.hotUrl.model.entity.HotUrlVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jin
 * @date 2021/8/13
 */
@Mapper
public interface HotUrlMapper extends BaseMapper<HotUrlPO> {

    /**
     * 分页获取网站链接
     * @param iPage 页码
     * @param queryWrapper 查询条件
     * @return 网站链接
     */
    IPage<HotUrlPO> queryUrlForPage
            (IPage<HotUrlVO> iPage, @Param("ew") QueryWrapper<HotUrlVO> queryWrapper);
}
