package yy.demo.demo1.base.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yinmb
 * @Date 2019/6/25 13:54:16
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {

        // 端口号
        int port = 7000;
        // 在端口上创建一个服务器套接字
        ServerSocket serverSocket = new ServerSocket(port);
        // 监听来自客户端的连接
        Socket socket = serverSocket.accept();

        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));

        DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(socket.getOutputStream()));

        double length = dis.readDouble();
        System.out.println("服务器端收到的边长数据为：" + length);
        double result = length * length;
        dos.writeDouble(result);
        dos.flush();

        while (dis.readInt() != 0){
            length = dis.readDouble();
            System.out.println("服务器端收到的边长数据为：" + length);
            result = length * length;
            dos.writeDouble(result);
            dos.flush();
        }

        socket.close();
        serverSocket.close();
    }
}
