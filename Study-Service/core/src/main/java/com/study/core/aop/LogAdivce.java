package com.study.core.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ：Curtain  
 * @date ：Created in 2020/12/22 10:25
 * @description：切面类
 * 创建一个AOP切面类，只要在类上加个 @Aspect 注解即可。
 * @Aspect 注解用来描述一个切面类，定义切面类的时候需要打上这个注解。
 * @Component 注解将该类交给 Spring来管理
 */
@Aspect
@Component
public class LogAdivce {
    //定义一个切点：所有被GetMapping注解修饰的方法会织入advice
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void logAdvicePointcut(){}
    
    //Before表示logAdvice将在目标方法执行前执行
    @Before("logAdvicePointcut()")
    public void logAdvice(){
        System.out.println("AOP：get请求的advice触发了");
    }
}
