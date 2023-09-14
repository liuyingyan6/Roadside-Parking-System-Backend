package com.woniuxy.inspector.config.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

@Configuration
public class BloomFilterConfig {
    @Bean
    public BloomFilter bloomFilter(){
        //设置布隆过滤器（key的字符集，预期存放的key的数量，期望误差率）
        return BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()),
                1000000,0.01);
    }
}