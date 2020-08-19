package com.study.bean.entity;

/**
 * @author ：Curtain
 * @date ：Created in 2020/8/5 10:17
 * @description：数据库字段信息
 */
public class DbFieldInfo {

    private String tableName;

    private String columnName;

    private String comments;

    private String owner;

    /**
     * 编辑距离
     */
    private int bjjl;

    public DbFieldInfo(String tableName, String columnName, String comments, String owner, int bjjl) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.comments = comments;
        this.owner = owner;
        this.bjjl = bjjl;
    }

    public DbFieldInfo() {
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBjjl() {
        return bjjl;
    }

    public void setBjjl(int bjjl) {
        this.bjjl = bjjl;
    }
}
