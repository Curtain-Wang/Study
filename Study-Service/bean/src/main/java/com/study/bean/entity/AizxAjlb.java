package com.study.bean.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "aizx_ajlb")
public class AizxAjlb implements Serializable {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 业务类别代码
     */
    private String ywlbdm;

    /**
     * 业务类别名称
     */
    private String ywlbmc;

    /**
     * 案件类别代码
     */
    private String ajlbdm;

    /**
     * 案件类别名称
     */
    private String ajlbmc;

    /**
     * 是否启用
     */
    private Integer sfqy;

    /**
     * 创建人id
     */
    private String cjrid;

    /**
     * 创建人
     */
    private String cjr;

    /**
     * 创建单位编号
     */
    @Column(name = "cjdw_dm")
    private String cjdwDm;

    /**
     * 创建单位名称
     */
    @Column(name = "cjdw_mc")
    private String cjdwMc;

    /**
     * 创建时间
     */
    private Date cjsj;

    /**
     * 修改人id
     */
    private String xgrid;

    /**
     * 修改人
     */
    private String xgr;

    /**
     * 修改单位编号
     */
    @Column(name = "xgdw_dm")
    private String xgdwDm;

    /**
     * 修改单位名称
     */
    @Column(name = "xgdw_mc")
    private String xgdwMc;

    /**
     * 修改时间
     */
    private Date xgsj;

    /**
     * 预留字段1
     */
    private String ylzd1;

    /**
     * 预留字段2

     */
    private String ylzd2;

    /**
     * 预留字段3
     */
    private String ylzd3;

    /**
     * 预留字段4
     */
    private String ylzd4;

    /**
     * 预留字段5
     */
    private Date ylzd5;

    /**
     * 预留字段6
     */
    private Date ylzd6;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取业务类别代码
     *
     * @return ywlbdm - 业务类别代码
     */
    public String getYwlbdm() {
        return ywlbdm;
    }

    /**
     * 设置业务类别代码
     *
     * @param ywlbdm 业务类别代码
     */
    public void setYwlbdm(String ywlbdm) {
        this.ywlbdm = ywlbdm;
    }

    /**
     * 获取业务类别名称
     *
     * @return ywlbmc - 业务类别名称
     */
    public String getYwlbmc() {
        return ywlbmc;
    }

    /**
     * 设置业务类别名称
     *
     * @param ywlbmc 业务类别名称
     */
    public void setYwlbmc(String ywlbmc) {
        this.ywlbmc = ywlbmc;
    }

    /**
     * 获取案件类别代码
     *
     * @return ajlbdm - 案件类别代码
     */
    public String getAjlbdm() {
        return ajlbdm;
    }

    /**
     * 设置案件类别代码
     *
     * @param ajlbdm 案件类别代码
     */
    public void setAjlbdm(String ajlbdm) {
        this.ajlbdm = ajlbdm;
    }

    /**
     * 获取案件类别名称
     *
     * @return ajlbmc - 案件类别名称
     */
    public String getAjlbmc() {
        return ajlbmc;
    }

    /**
     * 设置案件类别名称
     *
     * @param ajlbmc 案件类别名称
     */
    public void setAjlbmc(String ajlbmc) {
        this.ajlbmc = ajlbmc;
    }

    /**
     * 获取是否启用
     *
     * @return sfqy - 是否启用
     */
    public Integer getSfqy() {
        return sfqy;
    }

    /**
     * 设置是否启用
     *
     * @param sfqy 是否启用
     */
    public void setSfqy(Integer sfqy) {
        this.sfqy = sfqy;
    }

    /**
     * 获取创建人id
     *
     * @return cjrid - 创建人id
     */
    public String getCjrid() {
        return cjrid;
    }

    /**
     * 设置创建人id
     *
     * @param cjrid 创建人id
     */
    public void setCjrid(String cjrid) {
        this.cjrid = cjrid;
    }

    /**
     * 获取创建人
     *
     * @return cjr - 创建人
     */
    public String getCjr() {
        return cjr;
    }

    /**
     * 设置创建人
     *
     * @param cjr 创建人
     */
    public void setCjr(String cjr) {
        this.cjr = cjr;
    }

    /**
     * 获取创建单位编号
     *
     * @return cjdw_dm - 创建单位编号
     */
    public String getCjdwDm() {
        return cjdwDm;
    }

    /**
     * 设置创建单位编号
     *
     * @param cjdwDm 创建单位编号
     */
    public void setCjdwDm(String cjdwDm) {
        this.cjdwDm = cjdwDm;
    }

    /**
     * 获取创建单位名称
     *
     * @return cjdw_mc - 创建单位名称
     */
    public String getCjdwMc() {
        return cjdwMc;
    }

    /**
     * 设置创建单位名称
     *
     * @param cjdwMc 创建单位名称
     */
    public void setCjdwMc(String cjdwMc) {
        this.cjdwMc = cjdwMc;
    }

    /**
     * 获取创建时间
     *
     * @return cjsj - 创建时间
     */
    public Date getCjsj() {
        return cjsj;
    }

    /**
     * 设置创建时间
     *
     * @param cjsj 创建时间
     */
    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    /**
     * 获取修改人id
     *
     * @return xgrid - 修改人id
     */
    public String getXgrid() {
        return xgrid;
    }

    /**
     * 设置修改人id
     *
     * @param xgrid 修改人id
     */
    public void setXgrid(String xgrid) {
        this.xgrid = xgrid;
    }

    /**
     * 获取修改人
     *
     * @return xgr - 修改人
     */
    public String getXgr() {
        return xgr;
    }

    /**
     * 设置修改人
     *
     * @param xgr 修改人
     */
    public void setXgr(String xgr) {
        this.xgr = xgr;
    }

    /**
     * 获取修改单位编号
     *
     * @return xgdw_dm - 修改单位编号
     */
    public String getXgdwDm() {
        return xgdwDm;
    }

    /**
     * 设置修改单位编号
     *
     * @param xgdwDm 修改单位编号
     */
    public void setXgdwDm(String xgdwDm) {
        this.xgdwDm = xgdwDm;
    }

    /**
     * 获取修改单位名称
     *
     * @return xgdw_mc - 修改单位名称
     */
    public String getXgdwMc() {
        return xgdwMc;
    }

    /**
     * 设置修改单位名称
     *
     * @param xgdwMc 修改单位名称
     */
    public void setXgdwMc(String xgdwMc) {
        this.xgdwMc = xgdwMc;
    }

    /**
     * 获取修改时间
     *
     * @return xgsj - 修改时间
     */
    public Date getXgsj() {
        return xgsj;
    }

    /**
     * 设置修改时间
     *
     * @param xgsj 修改时间
     */
    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    /**
     * 获取预留字段1
     *
     * @return ylzd1 - 预留字段1
     */
    public String getYlzd1() {
        return ylzd1;
    }

    /**
     * 设置预留字段1
     *
     * @param ylzd1 预留字段1
     */
    public void setYlzd1(String ylzd1) {
        this.ylzd1 = ylzd1;
    }

    /**
     * 获取预留字段2

     *
     * @return ylzd2 - 预留字段2

     */
    public String getYlzd2() {
        return ylzd2;
    }

    /**
     * 设置预留字段2

     *
     * @param ylzd2 预留字段2

     */
    public void setYlzd2(String ylzd2) {
        this.ylzd2 = ylzd2;
    }

    /**
     * 获取预留字段3
     *
     * @return ylzd3 - 预留字段3
     */
    public String getYlzd3() {
        return ylzd3;
    }

    /**
     * 设置预留字段3
     *
     * @param ylzd3 预留字段3
     */
    public void setYlzd3(String ylzd3) {
        this.ylzd3 = ylzd3;
    }

    /**
     * 获取预留字段4
     *
     * @return ylzd4 - 预留字段4
     */
    public String getYlzd4() {
        return ylzd4;
    }

    /**
     * 设置预留字段4
     *
     * @param ylzd4 预留字段4
     */
    public void setYlzd4(String ylzd4) {
        this.ylzd4 = ylzd4;
    }

    /**
     * 获取预留字段5
     *
     * @return ylzd5 - 预留字段5
     */
    public Date getYlzd5() {
        return ylzd5;
    }

    /**
     * 设置预留字段5
     *
     * @param ylzd5 预留字段5
     */
    public void setYlzd5(Date ylzd5) {
        this.ylzd5 = ylzd5;
    }

    /**
     * 获取预留字段6
     *
     * @return ylzd6 - 预留字段6
     */
    public Date getYlzd6() {
        return ylzd6;
    }

    /**
     * 设置预留字段6
     *
     * @param ylzd6 预留字段6
     */
    public void setYlzd6(Date ylzd6) {
        this.ylzd6 = ylzd6;
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
        AizxAjlb other = (AizxAjlb) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getYwlbdm() == null ? other.getYwlbdm() == null : this.getYwlbdm().equals(other.getYwlbdm()))
            && (this.getYwlbmc() == null ? other.getYwlbmc() == null : this.getYwlbmc().equals(other.getYwlbmc()))
            && (this.getAjlbdm() == null ? other.getAjlbdm() == null : this.getAjlbdm().equals(other.getAjlbdm()))
            && (this.getAjlbmc() == null ? other.getAjlbmc() == null : this.getAjlbmc().equals(other.getAjlbmc()))
            && (this.getSfqy() == null ? other.getSfqy() == null : this.getSfqy().equals(other.getSfqy()))
            && (this.getCjrid() == null ? other.getCjrid() == null : this.getCjrid().equals(other.getCjrid()))
            && (this.getCjr() == null ? other.getCjr() == null : this.getCjr().equals(other.getCjr()))
            && (this.getCjdwDm() == null ? other.getCjdwDm() == null : this.getCjdwDm().equals(other.getCjdwDm()))
            && (this.getCjdwMc() == null ? other.getCjdwMc() == null : this.getCjdwMc().equals(other.getCjdwMc()))
            && (this.getCjsj() == null ? other.getCjsj() == null : this.getCjsj().equals(other.getCjsj()))
            && (this.getXgrid() == null ? other.getXgrid() == null : this.getXgrid().equals(other.getXgrid()))
            && (this.getXgr() == null ? other.getXgr() == null : this.getXgr().equals(other.getXgr()))
            && (this.getXgdwDm() == null ? other.getXgdwDm() == null : this.getXgdwDm().equals(other.getXgdwDm()))
            && (this.getXgdwMc() == null ? other.getXgdwMc() == null : this.getXgdwMc().equals(other.getXgdwMc()))
            && (this.getXgsj() == null ? other.getXgsj() == null : this.getXgsj().equals(other.getXgsj()))
            && (this.getYlzd1() == null ? other.getYlzd1() == null : this.getYlzd1().equals(other.getYlzd1()))
            && (this.getYlzd2() == null ? other.getYlzd2() == null : this.getYlzd2().equals(other.getYlzd2()))
            && (this.getYlzd3() == null ? other.getYlzd3() == null : this.getYlzd3().equals(other.getYlzd3()))
            && (this.getYlzd4() == null ? other.getYlzd4() == null : this.getYlzd4().equals(other.getYlzd4()))
            && (this.getYlzd5() == null ? other.getYlzd5() == null : this.getYlzd5().equals(other.getYlzd5()))
            && (this.getYlzd6() == null ? other.getYlzd6() == null : this.getYlzd6().equals(other.getYlzd6()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getYwlbdm() == null) ? 0 : getYwlbdm().hashCode());
        result = prime * result + ((getYwlbmc() == null) ? 0 : getYwlbmc().hashCode());
        result = prime * result + ((getAjlbdm() == null) ? 0 : getAjlbdm().hashCode());
        result = prime * result + ((getAjlbmc() == null) ? 0 : getAjlbmc().hashCode());
        result = prime * result + ((getSfqy() == null) ? 0 : getSfqy().hashCode());
        result = prime * result + ((getCjrid() == null) ? 0 : getCjrid().hashCode());
        result = prime * result + ((getCjr() == null) ? 0 : getCjr().hashCode());
        result = prime * result + ((getCjdwDm() == null) ? 0 : getCjdwDm().hashCode());
        result = prime * result + ((getCjdwMc() == null) ? 0 : getCjdwMc().hashCode());
        result = prime * result + ((getCjsj() == null) ? 0 : getCjsj().hashCode());
        result = prime * result + ((getXgrid() == null) ? 0 : getXgrid().hashCode());
        result = prime * result + ((getXgr() == null) ? 0 : getXgr().hashCode());
        result = prime * result + ((getXgdwDm() == null) ? 0 : getXgdwDm().hashCode());
        result = prime * result + ((getXgdwMc() == null) ? 0 : getXgdwMc().hashCode());
        result = prime * result + ((getXgsj() == null) ? 0 : getXgsj().hashCode());
        result = prime * result + ((getYlzd1() == null) ? 0 : getYlzd1().hashCode());
        result = prime * result + ((getYlzd2() == null) ? 0 : getYlzd2().hashCode());
        result = prime * result + ((getYlzd3() == null) ? 0 : getYlzd3().hashCode());
        result = prime * result + ((getYlzd4() == null) ? 0 : getYlzd4().hashCode());
        result = prime * result + ((getYlzd5() == null) ? 0 : getYlzd5().hashCode());
        result = prime * result + ((getYlzd6() == null) ? 0 : getYlzd6().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ywlbdm=").append(ywlbdm);
        sb.append(", ywlbmc=").append(ywlbmc);
        sb.append(", ajlbdm=").append(ajlbdm);
        sb.append(", ajlbmc=").append(ajlbmc);
        sb.append(", sfqy=").append(sfqy);
        sb.append(", cjrid=").append(cjrid);
        sb.append(", cjr=").append(cjr);
        sb.append(", cjdwDm=").append(cjdwDm);
        sb.append(", cjdwMc=").append(cjdwMc);
        sb.append(", cjsj=").append(cjsj);
        sb.append(", xgrid=").append(xgrid);
        sb.append(", xgr=").append(xgr);
        sb.append(", xgdwDm=").append(xgdwDm);
        sb.append(", xgdwMc=").append(xgdwMc);
        sb.append(", xgsj=").append(xgsj);
        sb.append(", ylzd1=").append(ylzd1);
        sb.append(", ylzd2=").append(ylzd2);
        sb.append(", ylzd3=").append(ylzd3);
        sb.append(", ylzd4=").append(ylzd4);
        sb.append(", ylzd5=").append(ylzd5);
        sb.append(", ylzd6=").append(ylzd6);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}