package com.hot.hotUrl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hot.commonUtils.constant.SqlParameter;
import com.hot.commonUtils.utils.QueryVoToPageUtil;
import com.hot.hotUrl.mapper.HotUrlMapper;
import com.hot.hotUrl.model.entity.HotUrlPO;
import com.hot.hotUrl.model.entity.HotUrlVO;
import com.hot.hotUrl.service.HotUrlService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jin
 * @date 2021/8/13
 */
@Service
public class HotUrlServiceImpl extends ServiceImpl<HotUrlMapper, HotUrlPO> implements HotUrlService {
    private static final Logger logger = LoggerFactory.getLogger(HotUrlServiceImpl.class);
    
    
    @Override
    public List<HotUrlPO> queryAll() {
        HotUrlVO vo = new HotUrlVO();
        vo.setIsUse(1);
        QueryWrapper<HotUrlVO> wrapper = new QueryWrapper<>();
        List<HotUrlPO> list = this.baseMapper.selectList(this.paramsFormat(vo,wrapper));
        logger.info(list.toString());
        return list;
    }

    @Override
    public IPage<HotUrlVO> queryAllForPage(HotUrlVO hotUrlVO) {
        IPage page = QueryVoToPageUtil.toPage(hotUrlVO);
        QueryWrapper<HotUrlVO> wrapper = new QueryWrapper<>();
        return this.baseMapper.selectPage(page,this.paramsFormat(hotUrlVO,wrapper));
    }

    @Override
    public HotUrlPO queryUrlById(String id) {
        return this.baseMapper.selectById(id);
    }


    private  QueryWrapper paramsFormat(HotUrlVO vo, QueryWrapper wrapper) {
        if (wrapper == null) {
            wrapper = new QueryWrapper<>();
        }
        if (!StringUtils.isEmpty(vo.getPathName())){
            wrapper.eq(SqlParameter.URL_PATH_NAME,vo.getPathName());
        }
        if (!StringUtils.isEmpty(vo.getName())){
            wrapper.like(SqlParameter.URL_NAME,vo.getName());
        }
        if (!StringUtils.isEmpty(vo.getUrl())){
            wrapper.like(SqlParameter.URL_URL,vo.getUrl());
        }
        if (vo.getIsUse() != null){
            wrapper.eq(SqlParameter.URL_IS_USE,vo.getIsUse());
        }
        return wrapper;
    }
}
