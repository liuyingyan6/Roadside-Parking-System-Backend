package com.woniuxy.operator.pojos;

import com.woniuxy.operator.handler.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: ResponseResult
 * @Date 2023/8/4 22:26
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {
    // 业务状态码 200-成功
    private Integer code;
    // 业务状态码的描述
    private String msg;
    // 响应给前端的数据
    private T datas;

    public static ResponseResult ok(){
        return new ResponseResult(200,"ok",null);
    }

    public static <T> ResponseResult ok(T datas){
        return new ResponseResult(200,"ok",datas);
    }

    /**
     * 处理错误信息
     * @param errorCode
     * @return
     */
    public static ResponseResult fail(IErrorCode errorCode){
        return new ResponseResult(errorCode.getCode(),errorCode.getMessage(),null);
    }
}
