package com.study.web.config.schedule;

import java.util.concurrent.ScheduledFuture;

/**
 * @Author Curtain
 * @Date 2021/4/19 16:36
 * @Description
 */
public class Canceller implements Cancelable{

    private ScheduledFuture future;

    public Canceller(ScheduledFuture future) {
        this.future = future;
    }

    @Override
    public void cancel() {
        if (! this.isCancelled()) {
            this.future.cancel(false);
        }
    }

    @Override
    public boolean isCancelled() {
        return this.future.isCancelled();
    }
}
