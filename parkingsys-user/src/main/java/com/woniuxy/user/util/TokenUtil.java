package com.woniuxy.user.util;

import cn.hutool.jwt.JWTUtil;
import com.woniuxy.user.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TokenUtil
 * @Author Phil
 * @Date 2023/8/29 21:13
 * @Version 1.0
 */
public class TokenUtil {

    public static String createAccessToken(Integer accessTime, User user, String signature, HttpServletRequest request){
        //产生AccessToken(小/短令牌) ,RefreshToken(大/长令牌)
        Map<String,Object> payload = new HashMap<>();
        payload.put("exp", LocalDateTime.now().plusMinutes(accessTime).
                format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        payload.put("userId", user.getId());
        //获得登录者的IP地址
        String requestIP = getRequestIP(request);
        payload.put("requestIP", requestIP);
        //生成短令牌
        return JWTUtil.createToken(payload, signature.getBytes());
    }

    public static String createRefreshToken(Integer refreshTime, User user,String signature,HttpServletRequest request){
        //产生AccessToken(小/短令牌) ,RefreshToken(大/长令牌)
        Map<String,Object> payload = new HashMap<>();
        payload.put("exp", LocalDateTime.now().plusDays(refreshTime).
                format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        payload.put("userId", user.getId());
        //获得登录者的IP地址
        String requestIP = getRequestIP(request);
        payload.put("requestIP", requestIP);
        //生成长令牌
        return JWTUtil.createToken(payload, signature.getBytes());
    }

    // 获取请求的IP地址
    public static String getRequestIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
