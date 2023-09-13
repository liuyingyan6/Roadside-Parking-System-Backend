package com.woniuxy.operator.pojos;

import com.woniuxy.operator.handler.BusinessEnum;
import com.woniuxy.operator.handler.IErrorCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {

    @ApiModelProperty("响应状态码")
    private Integer code;
    @ApiModelProperty("响应数据")
    private T data;
    @ApiModelProperty("返回信息")
    private String message;


    public static ResponseResult ok(){
        return new ResponseResult(200,null,"ok");
    }

    public static <T> ResponseResult ok(T data){
        return new ResponseResult(200,data,"ok");
    }

    /**
     * 操作失败
     */
    public static <T> ResponseResult <T> error() {
        return new ResponseResult(500,null,"ok");
    }
    /**
     * 处理错误信息
     */
    public static ResponseResult fail(IErrorCode errorCode){
        return new ResponseResult(errorCode.getCode(),errorCode.getMessage(),null);
    }
}
