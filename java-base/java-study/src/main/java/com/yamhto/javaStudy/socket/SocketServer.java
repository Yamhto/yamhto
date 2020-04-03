package com.yamhto.javaStudy.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author yamhto
 * @className: SocketServer.java
 * @package com.yamhto.javaStudy.socket
 * @description:
 * @date 2020/3/30 19:39
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        createSocket();
    }

    private static void createSocket() throws IOException {
        ServerSocket socket = new ServerSocket(8080);



        while (true) {
            //等客户端连接，线程阻塞
            System.out.println("read.....");

            Socket accept1 = socket.accept();

            //等客户端发送数据，线程阻塞
            System.out.println("连接成功等待消息。。。。");

            InputStream inputStream = accept1.getInputStream();
            byte[] bytes = new byte[1024];
            inputStream.read(bytes, 0, bytes.length);

            System.out.println(new String(bytes));
        }
    }
}
