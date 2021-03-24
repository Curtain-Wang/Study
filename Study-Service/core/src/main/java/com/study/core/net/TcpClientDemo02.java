package com.study.core.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 文件上传-客户端
 */
public class TcpClientDemo02 {
   public static void main(String[] args) throws IOException {
        //1.创建一个Socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        //2.创建一个输出流
        OutputStream os = socket.getOutputStream();
        //3.读取文件
        FileInputStream fis = new FileInputStream(new File("1.jpg"));
        //4.写出文件
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }

        //通知服务器，我已经传输完了
        socket.shutdownOutput();

        //确定服务器接受完了才能断开连接
        InputStream is = socket.getInputStream();
        //String
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while((len2 = is.read(buffer2)) != -1){
            baos.write(buffer2, 0, len2);
        }
        System.out.println(baos.toString());
        //关闭资源
        fis.close();
        os.close();
        socket.close();
    }
}
