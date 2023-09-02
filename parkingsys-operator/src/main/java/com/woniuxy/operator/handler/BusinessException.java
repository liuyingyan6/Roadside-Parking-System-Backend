package com.woniuxy.operator.handler;

import lombok.Getter;

/**
 * @Description: BusinessException
 * @Date 2023/8/7 18:59
 * @Version 1.0
 */
@Getter
public class BusinessException extends RuntimeException {
    private IErrorCode errorCode;
    public BusinessException() {
    }
    public BusinessException(IErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
