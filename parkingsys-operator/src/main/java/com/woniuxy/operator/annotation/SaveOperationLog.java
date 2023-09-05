package com.woniuxy.operator.annotation;

import java.lang.annotation.*;

/**
 * 登录日志 自定义注解
 **/

@Target(ElementType.METHOD) // 表示该注解标注在方法上
@Retention(RetentionPolicy.RUNTIME) // 作用域是在运行时
@Documented
public @interface SaveOperationLog {

    /**
     * 描述
     */
    String description() default "";

    /**
     * 方法类型 INSERT DELETE UPDATE OTHER
     */
    String methodType() default "";
}
