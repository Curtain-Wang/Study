package com.study.web.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.study.core.config.DataSourceContextHolder;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author ：Curtain
 * @date ：Created in 2020/7/15 16:05
 * @description：TODO
 */
@Configuration
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class DynamicDataSourceConfig {

    @Bean(name = "db01")
    @ConfigurationProperties(prefix = "spring.datasource.db01")
    public DataSource db01(){
        return new DruidDataSource();
    }


    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource(){
        AbstractRoutingDataSource dynamicDataSource = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return DataSourceContextHolder.getDataSource();
            }
        };
        dynamicDataSource.setDefaultTargetDataSource(db01());
        HashMap<Object,Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceEnum.DB01.getCode(),db01());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.afterPropertiesSet();
        return dynamicDataSource;
    }
}
