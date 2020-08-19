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

    @Bean(name = "jcyDB")
    @ConfigurationProperties(prefix = "spring.datasource.jcy-db")
    public DataSource jcyDB(){
        return new DruidDataSource();
    }

    @Bean(name = "xtglDB")
    @ConfigurationProperties(prefix = "spring.datasource.xtgl-db")
    public DataSource xtglDB(){
        return new DruidDataSource();
    }

    @Bean(name = "oraDB")
    @ConfigurationProperties(prefix = "spring.datasource.ora-db")
    public DataSource oraDB(){
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
        dynamicDataSource.setDefaultTargetDataSource(jcyDB());
        HashMap<Object,Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceEnum.JCY_DB.getCode(),jcyDB());
        dataSourceMap.put(DataSourceEnum.XTGL_DB.getCode(),xtglDB());
        dataSourceMap.put(DataSourceEnum.ORA_DB.getCode(), oraDB());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.afterPropertiesSet();
        return dynamicDataSource;
    }
}
