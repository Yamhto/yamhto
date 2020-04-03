package com.yamhto.javaStudy.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author yamhto
 * @className: NioSocketServer.java
 * @package com.yamhto.javaStudy.socket
 * @description:
 * @date 2020/4/1 18:26
 */
public class NioSocketServer {
    public static void main(String[] args) throws IOException {
        createSocket();
    }

    private static void createSocket() throws IOException {
        ServerSocket socket = new ServerSocket(8080);

        while (true) {
            System.out.println("read.....");

            Socket accept1 = socket.accept();

            SocketChannel channel = accept1.getChannel();

            System.out.println("连接成功等待消息。。。。");

            ByteBuffer[] byteBuffers = new ByteBuffer[1024];

            channel.read(byteBuffers,0,byteBuffers.length);



            System.out.println(byteBuffers.toString());
        }
    }

}
