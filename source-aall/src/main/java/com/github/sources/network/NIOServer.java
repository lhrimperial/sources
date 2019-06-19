<<<<<<< HEAD
package com.github.sources.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 **/
public class NIOServer {

    private int port;
    private Selector selector;
    private ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        new NIOServer(8080).start();
    }

    public NIOServer(int port) {
        this.port = port;
    }

    private void start() {
        this.init();
        while (true) {
            try {
                int event = selector.select();
                if (event > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isAcceptable()) {
                            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                            SocketChannel sc = ssc.accept();
                            sc.configureBlocking(false);

                            sc.register(selector, SelectionKey.OP_READ);
                            System.out.println("client connect : " + sc.getRemoteAddress());
                        } else {
                            executor.submit(new ServerHandler(key));
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void init() {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress(port));

            selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("server started...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static class ServerHandler implements Runnable {
        private SelectionKey selectionKey;

        public ServerHandler(SelectionKey key) {
            this.selectionKey = key;
        }

        @Override
        public void run() {
            if (selectionKey.isReadable()) {
                SocketChannel channel = (SocketChannel) selectionKey.channel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                try {
                    channel.read(buffer);
                    buffer.flip();
                    System.out.println("收到客户端"+channel.socket().getInetAddress().getHostName()+"的数据："+new String(buffer.array()));
                    //将数据添加到key中
                    ByteBuffer outBuffer = ByteBuffer.wrap(buffer.array());
                    channel.write(outBuffer);// 将消息回送给客户端
                    selectionKey.cancel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

=======
package com.github.sources.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** */
public class NIOServer {

    private int port;
    private Selector selector;
    private ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        new NIOServer(8080).start();
    }

    public NIOServer(int port) {
        this.port = port;
    }

    private void start() {
        this.init();
        while (true) {
            try {
                int event = selector.select();
                if (event > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isAcceptable()) {
                            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                            SocketChannel sc = ssc.accept();
                            sc.configureBlocking(false);

                            sc.register(selector, SelectionKey.OP_READ);
                            System.out.println("client connect : " + sc.getRemoteAddress());
                        } else {
                            executor.submit(new ServerHandler(key));
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void init() {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress(port));

            selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("server started...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ServerHandler implements Runnable {
        private SelectionKey selectionKey;

        public ServerHandler(SelectionKey key) {
            this.selectionKey = key;
        }

        @Override
        public void run() {
            if (selectionKey.isReadable()) {
                SocketChannel channel = (SocketChannel) selectionKey.channel();
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                try {
                    channel.read(buffer);
                    buffer.flip();
                    System.out.println(
                            "收到客户端"
                                    + channel.socket().getInetAddress().getHostName()
                                    + "的数据："
                                    + new String(buffer.array()));
                    // 将数据添加到key中
                    ByteBuffer outBuffer = ByteBuffer.wrap(buffer.array());
                    channel.write(outBuffer); // 将消息回送给客户端
                    selectionKey.cancel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
>>>>>>> 53a2c382af697e2464c9c2a9cf5506d6eb213d9c
