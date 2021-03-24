package com.study.core.net;

import java.net.*;

public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        //1.建立一个socket
        DatagramSocket socket = new DatagramSocket();

        //2.建个包
        String msg = "你好啊，服务器!";
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 9090;
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, inetAddress, port);
        //3.发个包
        socket.send(datagramPacket);
        //4.关闭流
        socket.close();
    }
}
