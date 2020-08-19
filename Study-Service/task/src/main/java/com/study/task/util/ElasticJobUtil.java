package com.study.task.util;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElasticJobUtil {

    private static final Logger logger = LoggerFactory.getLogger(ElasticJobUtil.class);

    private static ZookeeperRegistryCenter regCenter;

    @Autowired
    public void setRegCenter(ZookeeperRegistryCenter regCenter) {
        ElasticJobUtil.regCenter = regCenter;
    }

    public static boolean addSimpleJob(String jobName,
                                       String description,
                                       SimpleJob simpleJob,
                                       String cron,
                                       int shardingTotalCount) {
        return addSimpleJob(jobName,description,simpleJob,cron,shardingTotalCount,null,null);
    }

    public static boolean addSimpleJob(String jobName,
                                          String description,
                                          SimpleJob simpleJob,
                                          String cron,
                                          int shardingTotalCount,
                                          String jobParameter) {
        return addSimpleJob(jobName,description,simpleJob,cron,shardingTotalCount,jobParameter,null);
    }

    public static boolean addSimpleJob(String jobName,
                                          String description,
                                          SimpleJob simpleJob,
                                          String cron,
                                          int shardingTotalCount,
                                          String jobParameter,
                                          ElasticJobListener elasticJobListener) {
        try {
            JobCoreConfiguration.Builder jobBuilder = JobCoreConfiguration.newBuilder(jobName, cron, shardingTotalCount);
            if (StringUtils.isNotBlank(jobParameter)){
                jobBuilder.jobParameter(jobParameter);
            }
            if (StringUtils.isNotBlank(description)){
                jobBuilder.description(description);
            }
            jobBuilder.failover(true);
            JobCoreConfiguration jobConfig = jobBuilder.build();
            SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jobConfig, simpleJob.getClass().getCanonicalName());

            LiteJobConfiguration liteJobConfiguration =
                    LiteJobConfiguration.newBuilder(simpleJobConfiguration)
                            .overwrite(true)
                            .build();

            SpringJobScheduler springJobScheduler = null;
            if (elasticJobListener != null){
                springJobScheduler = new SpringJobScheduler(simpleJob, regCenter,liteJobConfiguration,elasticJobListener);
            }else{
                springJobScheduler = new SpringJobScheduler(simpleJob, regCenter,liteJobConfiguration);
            }
            springJobScheduler.init();
            return true;
        }catch (Exception e){
            logger.error(">>>addSimpleJob fail,cause:{}",e);
            return false;
        }
    }

}
