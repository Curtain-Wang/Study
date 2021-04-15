package com.study.bean.exception;

import com.study.bean.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author Curtain
 * @Date 2021/4/15 20:06
 * @Description 接口调用异常类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiException extends RuntimeException{

    /**
     * 错误状态码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    public ApiException(ResponseEnum responseEnum){
        super(responseEnum.getCode());
        this.errorCode = responseEnum.getCode();
        this.errorMsg = responseEnum.getMessage();
    }

    public ApiException(String errorCode, String errorMsg, Throwable cause){
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ApiException(ResponseEnum responseEnum, Throwable cause){
        super(responseEnum.getCode(), cause);
        this.errorCode = responseEnum.getCode();
        this.errorMsg = responseEnum.getMessage();
    }
}
