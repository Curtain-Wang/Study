package com.study.bean.response;

import com.study.bean.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author Curtain
 * @Date 2021/4/15 20:12
 * @Description
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultBody<T> {
    /**
     * 状态码
     */
    private String code;
    /**
     * 状态信息
     */
    private String message;
    /**
     * 接口返回数据
     */
    private T result;

    public ResultBody(ResponseEnum responseEnum){
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public static ResultBody success(){
        return success(null);
    }

    public static <T> ResultBody<T> success(T o) {
        ResultBody resultBody = new ResultBody(ResponseEnum.SUCCESS);
        resultBody.setResult(o);
        return resultBody;
    }

    public static ResultBody error(ResponseEnum responseEnum){
        return new ResultBody(responseEnum);
    }

    public static ResultBody error(String code, String message){
        return new ResultBody(code, message, null);
    }

    public static ResultBody error(String message){
        return new ResultBody("-1", message, null);
    }
}
