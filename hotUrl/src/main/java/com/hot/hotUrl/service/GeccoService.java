package com.hot.hotUrl.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jin
 * @date 2023/5/19
 */
@FeignClient(name = "gecco",url="${interfaceInfo.gecco}")
public interface GeccoService {
    
    /**
     * 初始化Gecco
     */
    @RequestMapping(method = RequestMethod.GET, value="/gecco/initGecco",
            consumes = "application/json;charset=utf-8")
    void initGecco();
}
