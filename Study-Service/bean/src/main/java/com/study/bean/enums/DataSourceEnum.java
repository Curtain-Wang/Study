package com.study.bean.enums;

/**
 * @author ：Curtain
 * @date ：Created in 2020/7/15 16:02
 * @description：数据库的枚举
 */
public enum DataSourceEnum {

    DB01("db01", "一号数据库");


    private String code;

    private String desc;

    DataSourceEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
