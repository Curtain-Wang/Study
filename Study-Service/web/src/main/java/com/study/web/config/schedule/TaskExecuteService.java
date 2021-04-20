package com.study.web.config.schedule;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * @Author Curtain
 * @Date 2021/4/19 16:47
 * @Description
 */
@Service
public class TaskExecuteService implements Executable{

    @Resource(name = "taskPoolScheduler")
    private ThreadPoolTaskScheduler taskScheduler;

    @Resource(name = "workPoolExecutor")
    private ThreadPoolTaskExecutor taskExecutor;

    @Override
    public void runAsync(Runnable task) {
        taskExecutor.execute(task);
    }

    @Override
    public Cancelable runPeriodly(Runnable task, long seconds) {
        long milliSeconds = seconds * 1000;

        ScheduledFuture scheduledFuture = taskScheduler.scheduleAtFixedRate(task, milliSeconds);
        return new Canceller(scheduledFuture);
    }

    @Override
    public Cancelable runOnceSchedule(Runnable task, Date date) {
        ScheduledFuture scheduledFuture = taskScheduler.schedule(task,date);
        return new Canceller(scheduledFuture);
    }

    @Override
    public Cancelable runPeriodlyMilliSeconds(Runnable task, long milliSeconds) {
        ScheduledFuture scheduledFuture = taskScheduler.scheduleAtFixedRate(task, milliSeconds);
        return new Canceller(scheduledFuture);
    }

    @Override
    public void runExclusively(Runnable task, String taskName) {
        new Thread(task, taskName).start();
    }
}
