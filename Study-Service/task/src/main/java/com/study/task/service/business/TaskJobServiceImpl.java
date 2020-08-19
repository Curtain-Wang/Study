package com.study.task.service.business;

import com.study.task.service.api.TaskJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author ：Curtain
 * @date ：Created in 2020/7/16 15:26
 * @description：TODO
 */
@Service
public class TaskJobServiceImpl implements TaskJobService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void helloWordTask() {
        logger.info("定时任务测试：Hello World");
    }
}
