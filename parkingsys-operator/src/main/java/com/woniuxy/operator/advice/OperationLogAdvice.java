package com.woniuxy.operator.advice;

import cn.hutool.core.convert.NumberWithFormat;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWTUtil;
import com.woniuxy.operator.entity.OperationLog;
import com.woniuxy.operator.service.IOperationLogService;
import com.woniuxy.operator.util.IPUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class OperationLogAdvice {
    @Autowired
    IOperationLogService iOperationLogService;

    @Pointcut("@annotation(com.woniuxy.operator.annotation.SaveOperationLog)")
    public void operationPointCut() {
    }

    /**
     * 环绕通知
     */
//    @Around("operationPointCut()")
//    public void operateSucceed(ProceedingJoinPoint point) {
    @AfterReturning(pointcut = "operationPointCut()")
    public void loginSucceed(JoinPoint point) {
        // 获取当前请求的 HttpServletRequest 对象
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();



        // 获得方法的参数
        for (Object arg : point.getArgs()) {
            System.out.println("arg = " + arg);
        }


        String servletPath = request.getServletPath(); // 获得url => 可以从url查到权限名字？
        String[] parts = servletPath.split("/");
        String module = parts[1];
        System.out.println("module = " + module); // 获得模块
        String operation = parts[2];
        System.out.println("operation = " + operation); // 获得操作

        String methodName = point.getSignature().getName();
        System.out.println("methodName = " + methodName); // 获得方法的名字

        String user_agent = request.getHeader("User-Agent");
        System.out.println("user_agent = " + user_agent);
        // user_agent = Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36

        // 获得userId
        String authorization = request.getHeader("Authorization");
        authorization = authorization.replace("Bearer ", "");
        NumberWithFormat managerIdNWF = (NumberWithFormat) JWTUtil.parseToken(authorization).getPayload("managerId");
        int managerId = managerIdNWF.intValue();

        String cityInfo = IPUtil.getCityInfoByFile("113.68.154.122");
        System.out.println("cityInfo = " + cityInfo); // 中国|0|广东省|广州市|电信

        // 创建对象并存到mysql
        OperationLog operationLog = new OperationLog();
        operationLog.setUserId(Long.valueOf(managerId));
        operationLog.setIp(IPUtil.getIpAddress(request));
        operationLog.setUrl(servletPath);
        operationLog.setCreateTime(DateTime.now());
        iOperationLogService.save(operationLog);
    }



}
