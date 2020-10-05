package com.github.sources.network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

/** */
public class NettyServer {

    private int port;

    public static void main(String[] args) {
        new NettyServer(8080).start();
    }

    public NettyServer(int port) {
        this.port = port;
    }

    public void start() {
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup work = new NioEventLoopGroup();

        try {
            ServerBootstrap server =
                    new ServerBootstrap()
                            .group(boss, work)
                            .channel(NioServerSocketChannel.class)
                            .localAddress(new InetSocketAddress(port))
                            .option(ChannelOption.SO_BACKLOG, 128)
                            .option(ChannelOption.SO_KEEPALIVE, true)
                            .childHandler(
                                    new ChannelInitializer<SocketChannel>() {
                                        @Override
                                        protected void initChannel(SocketChannel ch)
                                                throws Exception {
                                            ch.pipeline()
                                                    .addLast("decode", new StringDecoder())
                                                    .addLast("encode", new StringEncoder())
                                                    .addLast(new ServerHandler());
                                        }
                                    });

            ChannelFuture future = server.bind().sync();
            System.out.println("server started...");
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }

    public static class ServerHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("HelloWorldServerHandler active");
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("server channelRead..");
            System.out.println(ctx.channel().remoteAddress() + "->Server :" + msg.toString());
            ctx.write("server write " + msg);
            ctx.flush();
        }
    }
}
