package com.hot.gecco.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.spider.SpiderBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jin
 * @date 2021/8/20
 */
@Component
@PipelineName("redisPipeline")
public class RedisPipeline implements Pipeline<SpiderBean> {
    
    @Override
    public void process(SpiderBean bean) {
        JSONObject jsonObject =JSONObject.parseObject(JSON.toJSONString(bean));
        Map<String,Object> map = new HashMap<>(16);
        String content = "content";
        jsonObject.forEach((key,value)->{
            if (!(content).equals(key)){
                map.put("key",key);
            }else {
                map.put("content",value);
            }
        });
        
        RedisTemplate<String, Object> redisTemplate = RedisUtil.getRedisTemplate();
        redisTemplate.opsForValue().set(map.get("key").toString(),map.get("content").toString());
    }
}
