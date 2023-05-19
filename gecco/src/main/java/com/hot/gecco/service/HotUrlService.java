package com.hot.gecco.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jin
 * @date 2021/8/13
 */
@FeignClient(name = "hotUrl",url="${interfaceInfo.hotUrl}")
public interface HotUrlService {

    /**
     * 查询所有url链接-已启用
     * @return url链接
     */
    @RequestMapping(method = RequestMethod.GET, value="/hotUrl/queryAll",
            consumes = "application/json;charset=utf-8")
    JSONObject queryAllUrl();
}
