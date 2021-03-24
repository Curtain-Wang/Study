package com.study.core.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{

    DatagramSocket socket = null;
    private int fromPort;
    private String msgFrom;



    public TalkReceive() {
    }

    public TalkReceive(int fromPort, String msgFrom) {
        this.fromPort = fromPort;
        try {
            this.socket = new DatagramSocket(fromPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.msgFrom = msgFrom;
    }

    @Override
    public void run() {
        while (true){
            try {
                //2.准备接受包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                //3.阻塞式接收包裹
                socket.receive(packet);
                byte[] data = packet.getData();
                String receiveData = new String(data, 0, data.length);
                System.out.println(msgFrom + ":" + receiveData);
                if (receiveData.contains("bye"))
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
