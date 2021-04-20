package com.study.web.config.schedule;

/**
 * @Author Curtain
 * @Date 2021/4/19 16:36
 * @Description
 */
public interface Cancelable {
    /**
     * 取消（删除）已创建的定时任务
     * @return
     */
    void cancel();

    /**
     * 定时任务是否已删除
     * @return
     */
    boolean isCancelled();
}
