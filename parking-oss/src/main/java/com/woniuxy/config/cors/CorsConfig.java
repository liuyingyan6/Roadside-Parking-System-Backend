package com.woniuxy.config.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域的全局配置；做了全局配置，就不要再使用跨域注解了
 *
 * implements Filter
 */
@Configuration
public class CorsConfig {
    private final long MAX_AGE = 24 * 60 * 60 * 1000;

    @Bean // 创建对象，加入ioc容器
    public CorsFilter corsFilter() {
        // 创建跨域配置参数
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 设置允许的请求头、请求方式、请求来源
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.setMaxAge(MAX_AGE);
        // 基于url的跨域配置数据源
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }


}