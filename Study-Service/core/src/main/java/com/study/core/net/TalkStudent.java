package com.study.core.net;

public class TalkStudent {
    public static void main(String[] args) {
        //开启两个线程
        new Thread(new TalkSend("localhost", 9999, 7777)).start();
        new Thread(new TalkReceive(8888, "老师")).start();
    }
}
