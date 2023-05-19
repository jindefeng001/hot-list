package com.hot.hotUrl.controller;

import com.hot.commonUtils.core.ServiceErrorException;
import com.hot.commonUtils.core.SysResult;
import com.hot.hotUrl.model.entity.HotUrlPO;
import com.hot.hotUrl.model.entity.HotUrlVO;
import com.hot.hotUrl.service.GeccoService;
import com.hot.hotUrl.service.HotUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author jin
 * @date 2021/8/13
 */
@RestController
@RequestMapping(value = "/hotUrl", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Validated
public class HotUrlController {
    
    private HotUrlService hotUrlService;
    @Resource
    private GeccoService geccoService;
    @Autowired
    public void setHotUrlService(HotUrlService hotUrlService) {
        this.hotUrlService = hotUrlService;
    }

    @GetMapping(value = "queryAll")
    public SysResult queryAll() {
        return SysResult.success(this.hotUrlService.queryAll());
    }

    @GetMapping(value = "queryAllForPage")
    public SysResult queryAllForPage(@Valid HotUrlVO hotUrlVO) {
        return SysResult.success(this.hotUrlService.queryAllForPage(hotUrlVO));
    }

    @PostMapping()
    public SysResult saveVO(@Valid @RequestBody HotUrlPO po) {
        po.setIsUse(1);
        po.setIsDel(0);
        Boolean count = this.hotUrlService.save(po);
        geccoService.initGecco();
        return SysResult.success(count);
    }

    @PutMapping("/{id}")
    public SysResult updateVO(@RequestBody HotUrlPO po, @PathVariable Long id) {
        if (id == null || po == null || !id.equals(po.getId())) {
            throw new ServiceErrorException("主键值不匹配");
        }
        Boolean count = this.hotUrlService.updateById(po);
        geccoService.initGecco();
        return SysResult.success(count);
    }

    @GetMapping(value = "/{id}")
    public SysResult queryUrlById(@PathVariable String id) {
        return SysResult.success(this.hotUrlService.queryUrlById(id));
    }
}
