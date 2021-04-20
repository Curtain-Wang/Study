package com.study.web.config.schedule;

import java.util.Date;

/**
 * @Author Curtain
 * @Date 2021/4/19 16:36
 * @Description 定时任务执行接口
 */
public interface Executable {

    /**
     * 任务放在线程池中执行
     * @param task
     */
    void runAsync(Runnable task);

    /**
     * 定时执行
     *
     * @param task 可执行任务
     * @param seconds 定时执行的周期，单位是秒
     */
    Cancelable runPeriodly(Runnable task, long seconds);

    /**
     * 定时执行一次任务
     * @param task
     * @param date
     * @return
     */
    Cancelable runOnceSchedule(Runnable task, Date date);


    /**
     *
     * @param task
     * @param milliSeconds
     * @return
     */
    Cancelable runPeriodlyMilliSeconds(Runnable task, long milliSeconds);

    /**
     * 独占线程执行（新开线程执行）
     *
     * @param task 可执行任务
     */
    void runExclusively(Runnable task, String taskName);
}
