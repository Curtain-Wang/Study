package com.study.core.annotation.practice;

import com.study.core.annotation.MyFirstAnnotation;

/**
 * @author ：Curtain
 * @date ：Created in 2020/12/21 10:31
 * @description：自定义注解类使用
 */
@MyFirstAnnotation(name = "我的第一个注解类使用", value = "MyFirstAnnotationUse", path = "com.study.core.annotation.practice.MyFirstAnnotationUse")
public class MyFirstAnnotationUse {

    @MyFirstAnnotation(name = "名字", value = "柯腾", path = "MyFirstAnnotationUse.name")
    private String name;

    @MyFirstAnnotation(name = "年龄", value = "18", path = "MyFirstAnnotationUse.age")
    private int age;

    @MyFirstAnnotation(name = "测试注解", value = "testAnnotation", path = "MyFirstAnnotationUse.testAnnotation")
    public String testAnnotation(){
        return "测试注解成功";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
