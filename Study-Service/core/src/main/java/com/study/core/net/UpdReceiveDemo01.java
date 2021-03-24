package com.study.core.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UpdReceiveDemo01 {
    public static void main(String[] args) throws Exception {
        //1.开启端口
        DatagramSocket socket = new DatagramSocket(6666);
        while (true){
            //2.准备接受包裹
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            //3.阻塞式接收包裹
            socket.receive(packet);
            byte[] data = packet.getData();
            String receiveData = new String(data, 0, data.length);
            System.out.println(receiveData);
            if (receiveData.contains("bye"))
                break;
        }
        socket.close();
    }
}
