package com.woniuxy.user.config;

import com.woniuxy.user.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        Collections.addAll(whiteList,
                "/user/login",
                "/manager/login",
                "/token/refresh",
                "/**/druid/**",
                "/urlPermission/**",
                "/roleUrlPermission/**",
                "/manager/**");
        // registry.addInterceptor(loginInterceptor()).addPathPatterns("/**").excludePathPatterns(whiteList);
    }
}
