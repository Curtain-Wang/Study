package com.study.core.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ：Curtain
 * @date ：Created in 2020/11/16 10:41
 * @description：反射逻辑类
 */
public class ReflectClass {
    private final static String TAG = "com.study.core.reflect";

    //创建对象
    public static void reflectNewInstance(){
        try{
            //根据名字获取该类
            Class<?> classBook = Class.forName("com.study.core.reflect.Book");
            //创建这类的实例
            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setName("退后");
            book.setAuthor("周杰伦");
            System.out.println(TAG +"  reflectNewInstance book = " + book.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    //反射私有的构造方法
    public static void reflectPrivateConstructor(){
        try {
            Class<?> classBook = Class.forName("com.study.core.reflect.Book");
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class, String.class);
            declaredConstructorBook.setAccessible(true);
            Object objectBook = declaredConstructorBook.newInstance("周杰伦", "菊花台");
            Book book = (Book) objectBook;
            System.out.println(TAG +"  reflectPrivateConstructor book = " + book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //反射私有属性
    public static void reflectPrivateField(){
        try {
            Class<?> classBook = Class.forName("com.study.core.reflect.Book");
            Object objectBook = classBook.newInstance();
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(objectBook);
            System.out.println(TAG + "reflectPrivateField tag = " + tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //反射私有方法
    public static void reflectPrivateMethod(){
        try {
            Class<?> classBook = Class.forName("com.study.core.reflect.Book");
            Method methodBook = classBook.getDeclaredMethod("declaredMethod", int.class);
            methodBook.setAccessible(true);
            Object objectBook = classBook.newInstance();
            String string = (String) methodBook.invoke(objectBook, 0);
            System.out.println(TAG + "reflectPrivateMethod string = " + string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        reflectNewInstance();
        reflectPrivateConstructor();
        reflectPrivateField();
        reflectPrivateMethod();
    }
}
