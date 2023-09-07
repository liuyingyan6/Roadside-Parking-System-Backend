package com.woniuxy.common.handler;

/**
 * @Description: Asserts
 * @Date 2023/8/7 19:01
 * @Version 1.0
 */
public class Asserts {
    /**
     * 抛出异常
     * @param condition
     * @param errorCode
     */
    public static void fail(boolean condition, IErrorCode errorCode){
        if(condition == true) {
            throw new BusinessException(errorCode);
        }
    }
}
