package com.woniuxy.operator.advice;

import cn.hutool.core.convert.NumberWithFormat;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWTUtil;
import com.woniuxy.operator.annotation.SaveOperationLog;
import com.woniuxy.operator.entity.OperationLog;
import com.woniuxy.operator.service.IOperationLogService;
import com.woniuxy.operator.util.IPUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class OperationLogAdvice {
    @Autowired
    IOperationLogService iOperationLogService;

    @Pointcut("@annotation(com.woniuxy.operator.annotation.SaveOperationLog)")
    public void operationPointCut() {
    }

    @AfterReturning(pointcut = "operationPointCut()")
    public void loginSucceed(JoinPoint point) {
        // 获取当前请求的 HttpServletRequest 对象
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        // 获得userId
        String authorization = request.getHeader("Authorization");
        authorization = authorization.replace("Bearer ", "");
        NumberWithFormat managerIdNWF = (NumberWithFormat) JWTUtil.parseToken(authorization).getPayload("managerId");
        int userId = managerIdNWF.intValue();
        String ipAddress = IPUtil.getIpAddress(request); // 获得ip
        String url = request.getServletPath(); // 获得url

        // 拼接record
        Object[] args = point.getArgs();
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        SaveOperationLog annotation = method.getAnnotation(SaveOperationLog.class);
        String description = annotation.description();
        String string = args[0].toString();
        String record = description + ": " + string;

        // 创建对象并存到mysql
        OperationLog operationLog = new OperationLog(null, (long) userId, null, ipAddress, url, DateTime.now(), 0, record);
        iOperationLogService.save(operationLog);
    }


}
