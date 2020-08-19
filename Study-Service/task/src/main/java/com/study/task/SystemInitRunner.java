package com.study.task;

import com.study.task.job.HelloWordTaskJob;
import com.study.task.util.ElasticJobUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ：Curtain
 * @date ：Created in 2020/7/16 15:22
 * @description：项目启动时初始化类
 */
@Component
public class SystemInitRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private HelloWordTaskJob helloWordTaskJob;

    @Override
    public void run(String... args) throws Exception {
        logger.debug("------进入系统初始化工作开始-------");
        ElasticJobUtil.addSimpleJob("helloWordTaskJob", "定时输出helloworld", helloWordTaskJob, "*/5 * * * * ?",1, null, null) ;
        logger.debug("------进入系统初始化工作结束-------");
    }
}
