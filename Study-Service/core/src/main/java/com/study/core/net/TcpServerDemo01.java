package com.study.core.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现聊天-服务端
 */
public class TcpServerDemo01 {


    public static void main(String[] args) {
        ByteArrayOutputStream baos = null;
        InputStream is = null;
        Socket socket = null;
        ServerSocket serverSocket = null;
        try {
            //1.我得有个地址
            serverSocket = new ServerSocket(9999);
            //2.等待客户端连接过来
            socket = serverSocket.accept();
            //3.读取客户端的消息
            is = socket.getInputStream();
            //管道流
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
