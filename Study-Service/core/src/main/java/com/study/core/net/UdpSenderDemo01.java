package com.study.core.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        //1.开启端口
        DatagramSocket socket = new DatagramSocket(8888);
        //2.准备数据，控制台读取System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
            //3.发送数据
            socket.send(packet);
            if ("bye".equals(data))
                break;
        }
        //4.关闭资源
        socket.close();
    }
}
