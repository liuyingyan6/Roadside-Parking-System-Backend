package com.woniuxy.inspector.handler;

import com.woniuxy.inspector.pojos.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description: GlobalExceptionHandler
 * @Date 2023/8/7 18:59
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 表示该方法只处理业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseResult handler(BusinessException e){
        e.printStackTrace();
        return ResponseResult.fail(e.getErrorCode());
    }
}
