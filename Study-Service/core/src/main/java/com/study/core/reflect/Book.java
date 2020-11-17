package com.study.core.reflect;

/**
 * @author ：Curtain
 * @date ：Created in 2020/11/16 10:34
 * @description：被反射类
 */
public class Book {
    private final static String TAG = "BookTag";

    private String author;

    private String name;

    public Book(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public Book() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private String declaredMethod(int index){
        String string = null;
        switch (index){
            case 0:
                string = "I am declaredMethod 1 !";
                break;
            case 1:
                string = "I am declaredMethod 2 !";
                break;
            default:
                string = "I am declaredMethod 1 !";
        }
        return string;
    }
}
