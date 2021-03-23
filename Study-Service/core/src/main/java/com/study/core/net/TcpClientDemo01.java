package com.study.core.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 实现聊天-客户端
 */
public class TcpClientDemo01 {
    //1.要知道服务器的地址
    InetAddress serverIP;

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.要知道服务器的地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            //2.创建一个socket连接
            socket = new Socket(serverIP, port);
            //3.发送消息IO流
            os = socket.getOutputStream();
            os.write("您好".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (os != null)
                os.close();
            if (socket != null)
                socket.close();

        }
    }
}
