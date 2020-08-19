package com.study.task.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.study.task.service.api.TaskJobService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ：Curtain
 * @date ：Created in 2020/7/16 15:24
 * @description：TODO
 */
@Component
public class HelloWordTaskJob implements SimpleJob {

    @Resource
    private TaskJobService taskJobService;
    
    @Override
    public void execute(ShardingContext shardingContext) {
        taskJobService.helloWordTask();
    }
}
