package com.hot.gecco.controller;

import com.hot.gecco.service.GeccoService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jin
 * @date 2023/5/19
 */
@RestController
@RequestMapping(value = "/gecco", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Validated
public class GeccoController {
    
    @Resource
    private GeccoService geccoService;

    @GetMapping(value = "initGecco")
    public void initGecco() {
        this.geccoService.initGecco();
    }
    
}
