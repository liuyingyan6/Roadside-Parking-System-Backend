package com.woniuxy.operator.interceptor;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.woniuxy.operator.util.TokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description: LoginInterceptor
 * @Date 2023/8/30 14:16
 * @Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Value("${jwt.signature}")
    private String signature;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        //判断是否为NULL
        if(!StringUtils.hasLength(authorization)){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());//401
            return false;
        }
        //干掉 Bearer 头
        authorization = authorization.replace("Bearer ", "");
        //校验令牌是否合法
        if(!JWTUtil.verify(authorization,signature.getBytes())){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());//401
            return false;
        }
        //解析IP地址 & 发送HTTP请求的服务器IP地址进行比对
        JWT jwt = JWTUtil.parseToken(authorization);
        String requestIP = (String)jwt.getPayload("requestIP");//令牌内部的IP地址
        String httpIP = TokenUtil.getRequestIP(request);
        if(!requestIP.equals(httpIP)){//对比不成功，则表示HTTP请求，不是来自于同一台服务器
            response.setStatus(HttpStatus.UNAUTHORIZED.value());//401
            return false;
        }
        //判断令牌是否过期
        String exp = (String)jwt.getPayload("exp");
        LocalDateTime expTime = LocalDateTime.parse(exp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //当令牌时间，在当前时间的前面，则表示：令牌已经过期
        if(expTime.isBefore(LocalDateTime.now())){
            response.setStatus(HttpStatus.UNAUTHORIZED.value());//401
            return false;
        }
        //一切正常，则正常放行HTTP请求
        return true;
    }
}
