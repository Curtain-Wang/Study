package com.study.core.annotation.practice;

import com.study.core.annotation.MyFirstAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ：Curtain
 * @date ：Created in 2020/12/21 10:43
 * @description：自定义注解类测试
 */
public class MyFirstAnnotationTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class clazz = Class.forName("com.study.core.annotation.practice.MyFirstAnnotationUse");
        
        //获取类注解信息
        MyFirstAnnotation classAnno = (MyFirstAnnotation) clazz.getAnnotation(MyFirstAnnotation.class);
        System.out.println("=======================类的注解=======================");
        System.out.println("name: " + classAnno.name());
        System.out.println("value: " + classAnno.value());
        System.out.println("path: " + classAnno.path());
        
        //获取方法注解信息,ps:这里需要使用isAnnotationPresent判断方法上是否使用了注解
        Method[] allMethods = clazz.getDeclaredMethods();
        for (int i = 0; i < allMethods.length; i++){
            if (allMethods[i].isAnnotationPresent(MyFirstAnnotation.class)){
                MyFirstAnnotation methodAnno = allMethods[i].getAnnotation(MyFirstAnnotation.class);
                System.out.println("=======================方法的注解=======================");
                System.out.println("方法名: " + allMethods[i].getName());
                System.out.println("name: " + methodAnno.name());
                System.out.println("value: " + methodAnno.value());
                System.out.println("path: " + methodAnno.path());
            }
        }
        
        //获取属性注解信息
        Field nameField = clazz.getDeclaredField("name");
        MyFirstAnnotation fieldAnno = nameField.getAnnotation(MyFirstAnnotation.class);
        System.out.println("=======================属性的注解=======================");
        System.out.println("name: " + fieldAnno.name());
        System.out.println("value: " + fieldAnno.value());
        System.out.println("path: " + fieldAnno.path());
    }
}
