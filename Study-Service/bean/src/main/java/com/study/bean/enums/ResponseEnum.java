package com.study.bean.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Curtain
 * @Date 2021/4/15 19:52
 * @Description 接口返回情况
 */
@AllArgsConstructor
@Getter
public enum ResponseEnum {
    SUCCESS("200", "成功"),
    BODY_NOT_MATCH("400", "请求的数据格式不符"),
    SIGNATURE_NOT_MATCH("401", "请求的数字签名不匹配"),
    NOT_FOUND("404", "未找到该资源"),
    INTERAL_SERVER_ERROR("500", "服务器内部错误"),
    SERVER_BUSY("503", "服务器正忙，请稍后再试");

    /**
     * 错误码
     */
    String code;
    /**
     * 错误描述
     */
    String message;

}
