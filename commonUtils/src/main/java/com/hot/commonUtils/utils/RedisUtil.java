package com.hot.commonUtils.utils;

import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author jin
 * @date 2021/8/23
 */
public class RedisUtil {

    public static RedisTemplate<String, Object> getRedisTemplate(){
        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration();
        rsc.setPort(6379);
        rsc.setPassword("");
        rsc.setHostName("localhost");
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        JedisConnectionFactory fac = new JedisConnectionFactory(rsc);
        fac.afterPropertiesSet();
        template.setConnectionFactory(fac);
        template.setDefaultSerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }
}
