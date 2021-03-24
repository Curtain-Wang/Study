package com.study.core.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable{

    DatagramSocket socket = null;
    BufferedReader reader = null;
    private String toIP;
    private int toPort;
    private int fromPort;

    public TalkSend(){
    }

    public TalkSend(String toIP, int toPort, int fromPort) {
        try {
            this.socket = new DatagramSocket(fromPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.toIP = toIP;
        this.toPort = toPort;
        this.fromPort = fromPort;
    }

    @Override
    public void run() {
        while (true){
            try {
                String data = reader.readLine();
                byte[] datas = data.getBytes();
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIP, this.toPort));
                //3.发送数据
                socket.send(packet);
                if ("bye".equals(data))
                    break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //4.关闭资源
        socket.close();
    }
}
