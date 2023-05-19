package com.hot.gecco.init;

import com.alibaba.fastjson.JSONObject;
import com.geccocrawler.gecco.dynamic.DynamicGecco;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spider.HrefBean;
import com.hot.gecco.model.entity.HotUrlPO;
import com.hot.gecco.service.HotUrlService;
import com.hot.gecco.utils.GeccoUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jin
 * @date 2021/8/13
 */
@Component
public class GeccoInitListener implements CommandLineRunner {
    
    private final static String GECCOENTITYPATH = "com.hot.gecco.utils.GeccoEntity";
    
    @Resource
    private HotUrlService hotUrlService;
    

    @Override
    public void run(String... args) throws Exception {
        JSONObject jsonObject = hotUrlService.queryAllUrl();
        List<JSONObject> hotUrlPOList = JSONObject.parseObject(jsonObject.get("data").toString(),List.class);
        //JSONObject[] jsonObjects = JSONObject.parseObject(jsonObject.get("data").toString(),JSONObject[].class);
        int i = hotUrlPOList.size();
        List<HttpGetRequest> list = new ArrayList<>(i + 1);
        for (JSONObject object: hotUrlPOList){
            HotUrlPO hotUrl = JSONObject.parseObject(object.toString(),HotUrlPO.class);
            if (hotUrl.getIsUse() == 1){
                DynamicGecco.html()
                        .gecco(hotUrl.getUrl(), "redisPipeline")
                        .listField("content", HrefBean.class).csspath(hotUrl.getCssPath()).build()
                        .stringField(hotUrl.getPathName()).csspath(hotUrl.getPathName()).build()
                        .register();
                HttpGetRequest start = new HttpGetRequest(hotUrl.getUrl());
                start.setCharset("GBK");
                list.add(start);
            }
        }
        GeccoUtil geccoUtil = new GeccoUtil();
        geccoUtil.start(i,list,20000);
    }
}
