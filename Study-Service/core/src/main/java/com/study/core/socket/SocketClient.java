package com.study.core.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author ：Curtain
 * @date ：Created in 2020/11/11 10:56
 * @description：TODO
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        //要连接的服务器ip地址和端口
        String host = "127.0.0.1";
        int port = 7080;
        //与服务端建立连接
        Socket socket = new Socket(host, port);
        //建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好~~";
        socket.getOutputStream().write(message.getBytes());
        outputStream.close();
        socket.close();

    }
}
