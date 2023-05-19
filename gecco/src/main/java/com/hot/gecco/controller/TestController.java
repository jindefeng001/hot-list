package com.hot.gecco.controller;

import com.geccocrawler.gecco.dynamic.DynamicGecco;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spider.HrefBean;
import com.hot.gecco.utils.GeccoUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jin on 2021/8/3.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/getHot")
    public void getHot(){
        GeccoUtil getHot = new GeccoUtil();
        //DynamicGecco.html("com.hot.gecco.utils.GeccoEntity")
        //        .gecco("https://www.douban.com/group/explore", "consolePipeline")
        //        .listField("content", HrefBean.class).csspath(".article > div:nth-child(1) > div > div.bd > h3 > a").build()
        //        .register();
        //getHot.getHot(2);
        //GeccoEngine engine = new GeccoEngine();
        List<HttpGetRequest> list = new ArrayList<>(2);

        DynamicGecco.html()
                .gecco("https://www.zhihu.com/hot", "consolePipeline")
                .listField("content", HrefBean.class).csspath(".HotList-list > section:nth-child(1) > div.HotItem-content > a > h2").build()
                .stringField("zhihu").csspath("zhihu").build()
                .register();
        HttpGetRequest start = new HttpGetRequest("https://www.zhihu.com/hot");
        start.setCharset("GBK");
        list.add(start);

        GeccoUtil geccoUtil = new GeccoUtil();
        geccoUtil.start(2,list,20000);
    }
}
