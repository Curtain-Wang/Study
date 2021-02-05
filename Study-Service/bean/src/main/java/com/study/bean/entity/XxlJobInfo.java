package com.study.bean.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "xxl_job_info")
public class XxlJobInfo implements Serializable {
    @Id
    private Integer id;

    /**
     * 执行器主键ID
     */
    @Column(name = "job_group")
    private Integer jobGroup;

    @Column(name = "job_desc")
    private String jobDesc;

    @Column(name = "add_time")
    private Date addTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 作者
     */
    private String author;

    /**
     * 报警邮件
     */
    @Column(name = "alarm_email")
    private String alarmEmail;

    /**
     * 调度类型
     */
    @Column(name = "schedule_type")
    private String scheduleType;

    /**
     * 调度配置，值含义取决于调度类型
     */
    @Column(name = "schedule_conf")
    private String scheduleConf;

    /**
     * 调度过期策略
     */
    @Column(name = "misfire_strategy")
    private String misfireStrategy;

    /**
     * 执行器路由策略
     */
    @Column(name = "executor_route_strategy")
    private String executorRouteStrategy;

    /**
     * 执行器任务handler
     */
    @Column(name = "executor_handler")
    private String executorHandler;

    /**
     * 执行器任务参数
     */
    @Column(name = "executor_param")
    private String executorParam;

    /**
     * 阻塞处理策略
     */
    @Column(name = "executor_block_strategy")
    private String executorBlockStrategy;

    /**
     * 任务执行超时时间，单位秒
     */
    @Column(name = "executor_timeout")
    private Integer executorTimeout;

    /**
     * 失败重试次数
     */
    @Column(name = "executor_fail_retry_count")
    private Integer executorFailRetryCount;

    /**
     * GLUE类型
     */
    @Column(name = "glue_type")
    private String glueType;

    /**
     * GLUE备注
     */
    @Column(name = "glue_remark")
    private String glueRemark;

    /**
     * GLUE更新时间
     */
    @Column(name = "glue_updatetime")
    private Date glueUpdatetime;

    /**
     * 子任务ID，多个逗号分隔
     */
    @Column(name = "child_jobid")
    private String childJobid;

    /**
     * 调度状态：0-停止，1-运行
     */
    @Column(name = "trigger_status")
    private Byte triggerStatus;

    /**
     * 上次调度时间
     */
    @Column(name = "trigger_last_time")
    private Long triggerLastTime;

    /**
     * 下次调度时间
     */
    @Column(name = "trigger_next_time")
    private Long triggerNextTime;

    /**
     * GLUE源代码
     */
    @Column(name = "glue_source")
    private String glueSource;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取执行器主键ID
     *
     * @return job_group - 执行器主键ID
     */
    public Integer getJobGroup() {
        return jobGroup;
    }

    /**
     * 设置执行器主键ID
     *
     * @param jobGroup 执行器主键ID
     */
    public void setJobGroup(Integer jobGroup) {
        this.jobGroup = jobGroup;
    }

    /**
     * @return job_desc
     */
    public String getJobDesc() {
        return jobDesc;
    }

    /**
     * @param jobDesc
     */
    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    /**
     * @return add_time
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * @param addTime
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取报警邮件
     *
     * @return alarm_email - 报警邮件
     */
    public String getAlarmEmail() {
        return alarmEmail;
    }

    /**
     * 设置报警邮件
     *
     * @param alarmEmail 报警邮件
     */
    public void setAlarmEmail(String alarmEmail) {
        this.alarmEmail = alarmEmail;
    }

    /**
     * 获取调度类型
     *
     * @return schedule_type - 调度类型
     */
    public String getScheduleType() {
        return scheduleType;
    }

    /**
     * 设置调度类型
     *
     * @param scheduleType 调度类型
     */
    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    /**
     * 获取调度配置，值含义取决于调度类型
     *
     * @return schedule_conf - 调度配置，值含义取决于调度类型
     */
    public String getScheduleConf() {
        return scheduleConf;
    }

    /**
     * 设置调度配置，值含义取决于调度类型
     *
     * @param scheduleConf 调度配置，值含义取决于调度类型
     */
    public void setScheduleConf(String scheduleConf) {
        this.scheduleConf = scheduleConf;
    }

    /**
     * 获取调度过期策略
     *
     * @return misfire_strategy - 调度过期策略
     */
    public String getMisfireStrategy() {
        return misfireStrategy;
    }

    /**
     * 设置调度过期策略
     *
     * @param misfireStrategy 调度过期策略
     */
    public void setMisfireStrategy(String misfireStrategy) {
        this.misfireStrategy = misfireStrategy;
    }

    /**
     * 获取执行器路由策略
     *
     * @return executor_route_strategy - 执行器路由策略
     */
    public String getExecutorRouteStrategy() {
        return executorRouteStrategy;
    }

    /**
     * 设置执行器路由策略
     *
     * @param executorRouteStrategy 执行器路由策略
     */
    public void setExecutorRouteStrategy(String executorRouteStrategy) {
        this.executorRouteStrategy = executorRouteStrategy;
    }

    /**
     * 获取执行器任务handler
     *
     * @return executor_handler - 执行器任务handler
     */
    public String getExecutorHandler() {
        return executorHandler;
    }

    /**
     * 设置执行器任务handler
     *
     * @param executorHandler 执行器任务handler
     */
    public void setExecutorHandler(String executorHandler) {
        this.executorHandler = executorHandler;
    }

    /**
     * 获取执行器任务参数
     *
     * @return executor_param - 执行器任务参数
     */
    public String getExecutorParam() {
        return executorParam;
    }

    /**
     * 设置执行器任务参数
     *
     * @param executorParam 执行器任务参数
     */
    public void setExecutorParam(String executorParam) {
        this.executorParam = executorParam;
    }

    /**
     * 获取阻塞处理策略
     *
     * @return executor_block_strategy - 阻塞处理策略
     */
    public String getExecutorBlockStrategy() {
        return executorBlockStrategy;
    }

    /**
     * 设置阻塞处理策略
     *
     * @param executorBlockStrategy 阻塞处理策略
     */
    public void setExecutorBlockStrategy(String executorBlockStrategy) {
        this.executorBlockStrategy = executorBlockStrategy;
    }

    /**
     * 获取任务执行超时时间，单位秒
     *
     * @return executor_timeout - 任务执行超时时间，单位秒
     */
    public Integer getExecutorTimeout() {
        return executorTimeout;
    }

    /**
     * 设置任务执行超时时间，单位秒
     *
     * @param executorTimeout 任务执行超时时间，单位秒
     */
    public void setExecutorTimeout(Integer executorTimeout) {
        this.executorTimeout = executorTimeout;
    }

    /**
     * 获取失败重试次数
     *
     * @return executor_fail_retry_count - 失败重试次数
     */
    public Integer getExecutorFailRetryCount() {
        return executorFailRetryCount;
    }

    /**
     * 设置失败重试次数
     *
     * @param executorFailRetryCount 失败重试次数
     */
    public void setExecutorFailRetryCount(Integer executorFailRetryCount) {
        this.executorFailRetryCount = executorFailRetryCount;
    }

    /**
     * 获取GLUE类型
     *
     * @return glue_type - GLUE类型
     */
    public String getGlueType() {
        return glueType;
    }

    /**
     * 设置GLUE类型
     *
     * @param glueType GLUE类型
     */
    public void setGlueType(String glueType) {
        this.glueType = glueType;
    }

    /**
     * 获取GLUE备注
     *
     * @return glue_remark - GLUE备注
     */
    public String getGlueRemark() {
        return glueRemark;
    }

    /**
     * 设置GLUE备注
     *
     * @param glueRemark GLUE备注
     */
    public void setGlueRemark(String glueRemark) {
        this.glueRemark = glueRemark;
    }

    /**
     * 获取GLUE更新时间
     *
     * @return glue_updatetime - GLUE更新时间
     */
    public Date getGlueUpdatetime() {
        return glueUpdatetime;
    }

    /**
     * 设置GLUE更新时间
     *
     * @param glueUpdatetime GLUE更新时间
     */
    public void setGlueUpdatetime(Date glueUpdatetime) {
        this.glueUpdatetime = glueUpdatetime;
    }

    /**
     * 获取子任务ID，多个逗号分隔
     *
     * @return child_jobid - 子任务ID，多个逗号分隔
     */
    public String getChildJobid() {
        return childJobid;
    }

    /**
     * 设置子任务ID，多个逗号分隔
     *
     * @param childJobid 子任务ID，多个逗号分隔
     */
    public void setChildJobid(String childJobid) {
        this.childJobid = childJobid;
    }

    /**
     * 获取调度状态：0-停止，1-运行
     *
     * @return trigger_status - 调度状态：0-停止，1-运行
     */
    public Byte getTriggerStatus() {
        return triggerStatus;
    }

    /**
     * 设置调度状态：0-停止，1-运行
     *
     * @param triggerStatus 调度状态：0-停止，1-运行
     */
    public void setTriggerStatus(Byte triggerStatus) {
        this.triggerStatus = triggerStatus;
    }

    /**
     * 获取上次调度时间
     *
     * @return trigger_last_time - 上次调度时间
     */
    public Long getTriggerLastTime() {
        return triggerLastTime;
    }

    /**
     * 设置上次调度时间
     *
     * @param triggerLastTime 上次调度时间
     */
    public void setTriggerLastTime(Long triggerLastTime) {
        this.triggerLastTime = triggerLastTime;
    }

    /**
     * 获取下次调度时间
     *
     * @return trigger_next_time - 下次调度时间
     */
    public Long getTriggerNextTime() {
        return triggerNextTime;
    }

    /**
     * 设置下次调度时间
     *
     * @param triggerNextTime 下次调度时间
     */
    public void setTriggerNextTime(Long triggerNextTime) {
        this.triggerNextTime = triggerNextTime;
    }

    /**
     * 获取GLUE源代码
     *
     * @return glue_source - GLUE源代码
     */
    public String getGlueSource() {
        return glueSource;
    }

    /**
     * 设置GLUE源代码
     *
     * @param glueSource GLUE源代码
     */
    public void setGlueSource(String glueSource) {
        this.glueSource = glueSource;
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
        XxlJobInfo other = (XxlJobInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobGroup() == null ? other.getJobGroup() == null : this.getJobGroup().equals(other.getJobGroup()))
            && (this.getJobDesc() == null ? other.getJobDesc() == null : this.getJobDesc().equals(other.getJobDesc()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getAlarmEmail() == null ? other.getAlarmEmail() == null : this.getAlarmEmail().equals(other.getAlarmEmail()))
            && (this.getScheduleType() == null ? other.getScheduleType() == null : this.getScheduleType().equals(other.getScheduleType()))
            && (this.getScheduleConf() == null ? other.getScheduleConf() == null : this.getScheduleConf().equals(other.getScheduleConf()))
            && (this.getMisfireStrategy() == null ? other.getMisfireStrategy() == null : this.getMisfireStrategy().equals(other.getMisfireStrategy()))
            && (this.getExecutorRouteStrategy() == null ? other.getExecutorRouteStrategy() == null : this.getExecutorRouteStrategy().equals(other.getExecutorRouteStrategy()))
            && (this.getExecutorHandler() == null ? other.getExecutorHandler() == null : this.getExecutorHandler().equals(other.getExecutorHandler()))
            && (this.getExecutorParam() == null ? other.getExecutorParam() == null : this.getExecutorParam().equals(other.getExecutorParam()))
            && (this.getExecutorBlockStrategy() == null ? other.getExecutorBlockStrategy() == null : this.getExecutorBlockStrategy().equals(other.getExecutorBlockStrategy()))
            && (this.getExecutorTimeout() == null ? other.getExecutorTimeout() == null : this.getExecutorTimeout().equals(other.getExecutorTimeout()))
            && (this.getExecutorFailRetryCount() == null ? other.getExecutorFailRetryCount() == null : this.getExecutorFailRetryCount().equals(other.getExecutorFailRetryCount()))
            && (this.getGlueType() == null ? other.getGlueType() == null : this.getGlueType().equals(other.getGlueType()))
            && (this.getGlueRemark() == null ? other.getGlueRemark() == null : this.getGlueRemark().equals(other.getGlueRemark()))
            && (this.getGlueUpdatetime() == null ? other.getGlueUpdatetime() == null : this.getGlueUpdatetime().equals(other.getGlueUpdatetime()))
            && (this.getChildJobid() == null ? other.getChildJobid() == null : this.getChildJobid().equals(other.getChildJobid()))
            && (this.getTriggerStatus() == null ? other.getTriggerStatus() == null : this.getTriggerStatus().equals(other.getTriggerStatus()))
            && (this.getTriggerLastTime() == null ? other.getTriggerLastTime() == null : this.getTriggerLastTime().equals(other.getTriggerLastTime()))
            && (this.getTriggerNextTime() == null ? other.getTriggerNextTime() == null : this.getTriggerNextTime().equals(other.getTriggerNextTime()))
            && (this.getGlueSource() == null ? other.getGlueSource() == null : this.getGlueSource().equals(other.getGlueSource()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getJobGroup() == null) ? 0 : getJobGroup().hashCode());
        result = prime * result + ((getJobDesc() == null) ? 0 : getJobDesc().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getAlarmEmail() == null) ? 0 : getAlarmEmail().hashCode());
        result = prime * result + ((getScheduleType() == null) ? 0 : getScheduleType().hashCode());
        result = prime * result + ((getScheduleConf() == null) ? 0 : getScheduleConf().hashCode());
        result = prime * result + ((getMisfireStrategy() == null) ? 0 : getMisfireStrategy().hashCode());
        result = prime * result + ((getExecutorRouteStrategy() == null) ? 0 : getExecutorRouteStrategy().hashCode());
        result = prime * result + ((getExecutorHandler() == null) ? 0 : getExecutorHandler().hashCode());
        result = prime * result + ((getExecutorParam() == null) ? 0 : getExecutorParam().hashCode());
        result = prime * result + ((getExecutorBlockStrategy() == null) ? 0 : getExecutorBlockStrategy().hashCode());
        result = prime * result + ((getExecutorTimeout() == null) ? 0 : getExecutorTimeout().hashCode());
        result = prime * result + ((getExecutorFailRetryCount() == null) ? 0 : getExecutorFailRetryCount().hashCode());
        result = prime * result + ((getGlueType() == null) ? 0 : getGlueType().hashCode());
        result = prime * result + ((getGlueRemark() == null) ? 0 : getGlueRemark().hashCode());
        result = prime * result + ((getGlueUpdatetime() == null) ? 0 : getGlueUpdatetime().hashCode());
        result = prime * result + ((getChildJobid() == null) ? 0 : getChildJobid().hashCode());
        result = prime * result + ((getTriggerStatus() == null) ? 0 : getTriggerStatus().hashCode());
        result = prime * result + ((getTriggerLastTime() == null) ? 0 : getTriggerLastTime().hashCode());
        result = prime * result + ((getTriggerNextTime() == null) ? 0 : getTriggerNextTime().hashCode());
        result = prime * result + ((getGlueSource() == null) ? 0 : getGlueSource().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jobGroup=").append(jobGroup);
        sb.append(", jobDesc=").append(jobDesc);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", author=").append(author);
        sb.append(", alarmEmail=").append(alarmEmail);
        sb.append(", scheduleType=").append(scheduleType);
        sb.append(", scheduleConf=").append(scheduleConf);
        sb.append(", misfireStrategy=").append(misfireStrategy);
        sb.append(", executorRouteStrategy=").append(executorRouteStrategy);
        sb.append(", executorHandler=").append(executorHandler);
        sb.append(", executorParam=").append(executorParam);
        sb.append(", executorBlockStrategy=").append(executorBlockStrategy);
        sb.append(", executorTimeout=").append(executorTimeout);
        sb.append(", executorFailRetryCount=").append(executorFailRetryCount);
        sb.append(", glueType=").append(glueType);
        sb.append(", glueRemark=").append(glueRemark);
        sb.append(", glueUpdatetime=").append(glueUpdatetime);
        sb.append(", childJobid=").append(childJobid);
        sb.append(", triggerStatus=").append(triggerStatus);
        sb.append(", triggerLastTime=").append(triggerLastTime);
        sb.append(", triggerNextTime=").append(triggerNextTime);
        sb.append(", glueSource=").append(glueSource);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}