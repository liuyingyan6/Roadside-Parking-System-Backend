package com.woniuxy.operator.handler;


public enum BusinessEnum implements IErrorCode{
    SUCCESS(200, "操作成功"),
    FAILURE(500, "系统内部错误"),
    SYSTEM_BUSY(10000,"系统繁忙，请稍后重试！"),
    OPTIMISTIC_LOCK_ERROR(10001,"网络波动异常，请稍后重试！"),
    VALIDATE_CODE_IS_NULL(10002,"验证码不能为空"),
    VALIDATE_CODE_ERROR(10003,"验证码错误"),
    ACCOUNT_PASSWORD_ERROR(10004,"账号或密码错误"),
    VALIDATE_CODE_EXPIRED(10005,"验证码已过期"),
    ACCOUNT_ALREADY_EXIST(10006,"账号已存在"),
    EMAIL_ALREADY_EXIST(10007,"邮箱已存在"),
    HTTP_ALREADY_HANDLE(20000,"请求已处理，请勿重复调用"),
    INVENTORY_NOT_ENOUGH(20001,"库存不足");

    private Integer code;
    private String message;
    private BusinessEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    @Override
    public Integer getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
