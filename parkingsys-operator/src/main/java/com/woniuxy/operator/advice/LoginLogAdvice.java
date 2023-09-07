package com.woniuxy.operator.advice;

import cn.hutool.core.date.DateTime;
import com.woniuxy.operator.entity.LoginLog;
import com.woniuxy.operator.pojos.ResponseResult;
import com.woniuxy.operator.service.ILoginLogService;
import com.woniuxy.operator.util.IPUtil;
import com.woniuxy.operator.vo.TokenVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LoginLogAdvice {
    @Autowired
    ILoginLogService iLoginLogService;

    @Pointcut(value = "execution(* com.woniuxy.operator.controller.ManagerController.login(..))")
    public void loginPointCut() {
    }

    /**
     * 后置通知，保存登录成功 日志
     */
    @AfterReturning(pointcut = "loginPointCut()", returning = "result")
    public void loginSucceed(JoinPoint joinPoint, ResponseResult result) {
        // 获取当前请求的 HttpServletRequest 对象
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        // 获取方法的返回结果
        TokenVO data = (TokenVO) result.getData();

//String ip = IPUtil.getIpAddress(request);
//获取ip，如果用localhost发请求会得到ip：0:0:0:0:0:0:0:1
        String ip = IPUtil.getIpAddr(request);
//String ip = request.getRemoteAddr();
        String location = IPUtil.getCityInfoByFile(ip);
        String userAgent = request.getHeader("User-Agent");
        String browserName = getBrowserName(userAgent);
        LoginLog loginLog = new LoginLog(null, data.getId(), 0, ip, DateTime.now(), 0, location, browserName); // 登录日志实体类
        iLoginLogService.save(loginLog); // 保存登录成功日志
    }

    private String getBrowserName(String userAgent) {
        // 判断是否为IE浏览器
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            // IE浏览器
            return "Internet Explorer";
        }
        // 判断是否为Firefox浏览器
        if (userAgent.contains("Firefox")) {
            // Firefox浏览器
            return "Firefox";
        }
        // 判断是否为Chrome浏览器
        if (userAgent.contains("Chrome")) {
            // Chrome浏览器
            return "Chrome";
        }
        // 判断是否为Safari浏览器
        if (userAgent.contains("Safari")) {
            // Safari浏览器
            return "Safari";
        }
        // 其他浏览器
        return "Unknown";
    }

}
