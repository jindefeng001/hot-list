package com.hot.hotList.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hot.commonUtils.utils.RedisUtil;
import com.hot.hotList.mapper.HotListMapper;
import com.hot.hotList.model.entity.HotListDetailPO;
import com.hot.hotList.model.entity.HotListPO;
import com.hot.hotList.service.HotListService;
import com.hot.hotList.service.HotUrlService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jin
 * @date 2021/8/23
 */
@Service
public class HotListServiceImpl extends ServiceImpl<HotListMapper, HotListPO> implements HotListService {

    private static final Logger logger = LoggerFactory.getLogger(HotListServiceImpl.class);

    private final RedisTemplate<String, Object> redisTemplate = RedisUtil.getRedisTemplate();

    private HotUrlService hotUrlService;
    @Autowired
    public void setHotUrlService(HotUrlService hotUrlService) {
        this.hotUrlService = hotUrlService;
    }

    @Override
    public List<HotListPO> queryHotList() {
        JSONObject jsonObject = hotUrlService.queryAllUrl();
        List<JSONObject> hotUrlList = JSONObject.parseObject(jsonObject.get("data").toString(),List.class);
        List<HotListPO> list = new ArrayList<>(hotUrlList.size());
        for (JSONObject object: hotUrlList){
            HotListPO hotList = new HotListPO();
            String key = object.getString("pathName");
            if (StringUtils.isNotBlank(key)){
                hotList.setKey(key);
                Object o = redisTemplate.opsForValue().get(key);
                List<HotListDetailPO> details = new ArrayList<>(16);
                List<JSONObject> detailsJson = new ArrayList<>(16);
                if (o != null) {
                    detailsJson = JSONObject.parseObject(o.toString(), List.class);
                    for (JSONObject detail: detailsJson){
                        HotListDetailPO detailPo = JSONObject.parseObject(detail.toString(),HotListDetailPO.class);
                        details.add(detailPo);
                    }
                }
                hotList.setListDetail(details);
                list.add(hotList);
            }
        }
        return list;
    }

    /**
     * 根据path获取热榜信息
     *
     * @param path
     * @return 热榜信息
     */
    @Override
    public HotListPO queryHotByPath(String path) {
        HotListPO hotList = new HotListPO();
        hotList.setKey(path);
        Object o = redisTemplate.opsForValue().get(path);
        List<HotListDetailPO> details = new ArrayList<>(16);
        List<JSONObject> detailsJson = new ArrayList<>(16);
        if (o != null) {
            detailsJson = JSONObject.parseObject(o.toString(), List.class);
            for (JSONObject detail: detailsJson){
                HotListDetailPO detailPo = JSONObject.parseObject(detail.toString(),HotListDetailPO.class);
                details.add(detailPo);
            }
        }
        hotList.setListDetail(details);
        return hotList;
    }
}
