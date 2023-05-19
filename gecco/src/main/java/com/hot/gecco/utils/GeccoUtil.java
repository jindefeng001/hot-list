package com.hot.gecco.utils;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;

import java.util.List;

/**
 *
 * @author jin
 * @date 2021/8/5
 */
public class GeccoUtil {
    
    private static final GeccoEngine<?> GECCO_ENGINE = GeccoEngine.create("com.hot.gecco.utils")
            .interval(5000)
		.loop(true)
		.engineStart();
    
    
    public static void register(Class<?> rule){
        GECCO_ENGINE.register(rule);
    }

    public static void start(List<HttpGetRequest> list){
        for (HttpGetRequest request:list){
            start(request);
        }
    }

    public static void start(HttpGetRequest request){
        GECCO_ENGINE.getScheduler().into(request);
    }
    
    public static void update(Class<?> rule){
        GECCO_ENGINE.beginUpdateRule();
        GECCO_ENGINE.register(rule);
    }

    public static void pause(){
        GECCO_ENGINE.pause();
    }
    
    public void start(Integer i, List<HttpGetRequest> list, Integer s){
        GeccoEngine.create()
                .classpath("com.hot.gecco.utils")
                //开始抓取的页面地址
                .seed(list)
                //开启几个爬虫线程,线程数量最好不要大于seed request数量
                .thread(i + 1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(s)
                //循环抓取
                .loop(true)
                //采用pc端userAgent
                .mobile(false)
                //是否开启debug模式，跟踪页面元素抽取
                .debug(false)
                //非阻塞方式运行
                .start();
    }
    
}
