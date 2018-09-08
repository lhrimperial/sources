package com.github.sources.network.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class BioServer {
    private int port;
    private ExecutorService service = Executors.newFixedThreadPool(3);

    public BioServer(int port) {
        this.port = port;
    }

    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                socket = serverSocket.accept();
                service.submit(new ServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ServerHandler extends AbstractNetwork implements Runnable {

        private Socket socket;

        public ServerHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader reader = null;
            PrintWriter writer = null;

            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);

                String threadName = Thread.currentThread().getName();
                String requestName = socket.getInetAddress().getHostName();
                String readerInfo = null;
                while (true) {
                    readerInfo = reader.readLine();
                    if (readerInfo == null) {
                        break;
                    }
                    System.out.println("接收到客户端消息：" + readerInfo + ",处理线程：" + threadName);
                    writer.println(requestName + " 你的请求已处理，处理线程：" + threadName);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                close(reader, writer, socket);
            }
        }
    }

    public static void main(String[] args){
        new BioServer(8080).start();
    }

}
