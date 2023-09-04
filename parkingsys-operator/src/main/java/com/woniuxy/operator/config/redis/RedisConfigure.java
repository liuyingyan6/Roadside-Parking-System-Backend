package com.woniuxy.operator.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * @Description: RedisConfigure
 * @Date 2023/8/14 18:58
 * @Version 1.0
 */
@Configuration
public class RedisConfigure {

    @Resource
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public ValueOperations valueOperations(){
        return redisTemplate().opsForValue();
    }

    @Bean
    public ListOperations listOperations(){
        return redisTemplate().opsForList();
    }

    @Bean
    public ZSetOperations zSetOperations(){
        return redisTemplate().opsForZSet();
    }

    @Bean
    public RedisTemplate<String,Object> redisTemplate(){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        //配置连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //针对Key进行序列化
        StringRedisSerializer krs = new StringRedisSerializer();
        redisTemplate.setKeySerializer(krs);
        redisTemplate.setHashKeySerializer(krs);
        //针对Value进行序列化
        Jackson2JsonRedisSerializer vrs = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        //设定Jackson工具，可以操作Value对象的所有的属性
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        vrs.setObjectMapper(om);
        redisTemplate.setValueSerializer(vrs);
        redisTemplate.setHashValueSerializer(vrs);
        //redisTemplate 在对象的属性设置之后使用
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
