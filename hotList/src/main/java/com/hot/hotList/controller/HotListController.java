package com.hot.hotList.controller;

import com.hot.commonUtils.core.SysResult;
import com.hot.hotList.service.HotListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jin
 * @date 2021/8/23
 */
@RestController
@RequestMapping("/hotList")
public class HotListController {

    private HotListService hotListService;
    @Autowired
    public void setHotListService(HotListService hotListService) {
        this.hotListService = hotListService;
    }

    @GetMapping(value = "queryHotList")
    public SysResult queryHotList() {
        return SysResult.success(this.hotListService.queryHotList());
    }

    @GetMapping(value = "/{path}")
    public SysResult queryHotByPath(@PathVariable String path) {
        return SysResult.success(this.hotListService.queryHotByPath(path));
    }
}
