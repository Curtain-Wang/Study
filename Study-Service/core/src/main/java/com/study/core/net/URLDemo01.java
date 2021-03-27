package com.study.core.net;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * url下载网络资源
 */
public class URLDemo01 {
    public static void main(String[] args) throws Exception {
        //下载地址
        URL url = new URL("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.xiao89.com%2Fuploads%2Fallimg%2F190621%2F10-1Z621155F4.jpg&refer=http%3A%2F%2Fwww.xiao89.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619151575&t=97abcaf9c97635fefb86d02b1eee05b8");
        //连接这个资源 http
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("BlueCat.jpeg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer, 0, len);
        }
        //关闭资源
        fos.close();
        is.close();
        urlConnection.disconnect();
    }
}
