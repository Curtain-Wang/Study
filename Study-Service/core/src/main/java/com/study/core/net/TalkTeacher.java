package com.study.core.net;

public class TalkTeacher {
    public static void main(String[] args) {
        //开启两个线程
        new Thread(new TalkSend("localhost", 8888, 6666)).start();
        new Thread(new TalkReceive(9999, "学生")).start();
    }
}
