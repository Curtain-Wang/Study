package com.study.web.config.datasource;

import com.study.bean.enums.DataSourceEnum;
import com.study.core.config.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ：Curtain
 * @date ：Created in 2020/7/15 15:45
 * @description：设置数据源切换的切面
 */
@Component
@Aspect
@Order(0)
public class DataSourceAspect {
    
    //这个路径表达式的含义就是 返回值为任意类型，com.study.service.api.*.*类的任意方法名参数也是任意
    @Pointcut("execution( * com.study.service.api.*.*.*(..))")
    public void dataSource(){}

    @Before(value = "dataSource()",argNames = "point")
    public void changeDataSource(JoinPoint point){
        String path = point.getSignature().getDeclaringTypeName();
        DataSourceEnum[] values = DataSourceEnum.values();
        DataSourceContextHolder.clearDataSource();
        for (DataSourceEnum value : values) {
            if (path.contains(value.getCode())){
                DataSourceContextHolder.setDataSource(value.getCode());
            }
        }
    }

    @After("dataSource()")
    public void clearDataSource(){
        DataSourceContextHolder.clearDataSource();
    }
}
