package com.study.task.config;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author ：Curtain
 * @date ：Created in 2020/7/16 15:11
 * @description：TODO
 */
@Component
public class ElasticJobConfig {

    @Bean
    public JobEventConfiguration jobEventConfiguration(DataSource dataSource){
        return new JobEventRdbConfiguration(dataSource);
    }
}
