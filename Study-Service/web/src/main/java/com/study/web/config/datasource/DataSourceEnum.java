package com.study.web.config.datasource;

/**
 * @author ：Curtain
 * @date ：Created in 2020/7/15 16:02
 * @description：数据库的枚举
 */
public enum DataSourceEnum {

    JCY_DB("jcyDB", "检察院"),
    XTGL_DB("xtglDB", "系统管理"),
    ORA_DB("oraDB", "ORACLE数据库");


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
