package com.study.bean.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "dept")
public class Dept implements Serializable {
    /**
     * 部门编号
     */
    @Id
    private Long deptno;

    /**
     * 部门名称
     */
    private String dname;

    @Column(name = "db_source")
    private String dbSource;

    private static final long serialVersionUID = 1L;

    /**
     * 获取部门编号
     *
     * @return deptno - 部门编号
     */
    public Long getDeptno() {
        return deptno;
    }

    /**
     * 设置部门编号
     *
     * @param deptno 部门编号
     */
    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    /**
     * 获取部门名称
     *
     * @return dname - 部门名称
     */
    public String getDname() {
        return dname;
    }

    /**
     * 设置部门名称
     *
     * @param dname 部门名称
     */
    public void setDname(String dname) {
        this.dname = dname;
    }

    /**
     * @return db_source
     */
    public String getDbSource() {
        return dbSource;
    }

    /**
     * @param dbSource
     */
    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Dept other = (Dept) that;
        return (this.getDeptno() == null ? other.getDeptno() == null : this.getDeptno().equals(other.getDeptno()))
            && (this.getDname() == null ? other.getDname() == null : this.getDname().equals(other.getDname()))
            && (this.getDbSource() == null ? other.getDbSource() == null : this.getDbSource().equals(other.getDbSource()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeptno() == null) ? 0 : getDeptno().hashCode());
        result = prime * result + ((getDname() == null) ? 0 : getDname().hashCode());
        result = prime * result + ((getDbSource() == null) ? 0 : getDbSource().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptno=").append(deptno);
        sb.append(", dname=").append(dname);
        sb.append(", dbSource=").append(dbSource);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}