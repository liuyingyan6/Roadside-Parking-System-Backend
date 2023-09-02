package com.woniuxy.operator.config;

import com.woniuxy.operator.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: WebMvcConfiguration
 * @Date 2023/8/10 19:35
 * @Version 1.0
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> whiteList = new ArrayList<>();
        //以后：swagger，druid 的一些请求，也需要放行
        Collections.addAll(whiteList,"/manager/login","/token/refresh","/**/druid/**");
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**").excludePathPatterns(whiteList);
    }
}
