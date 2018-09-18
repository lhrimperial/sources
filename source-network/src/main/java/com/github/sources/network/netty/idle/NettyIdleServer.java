package com.github.sources.network.netty.idle;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class NettyIdleServer {
    private int port;

    public NettyIdleServer(int port) {
        this.port = port;
    }

    public void start() {
        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup work = new NioEventLoopGroup();

        try {
            ServerBootstrap server = new ServerBootstrap().group(boss, work).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128).localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                            /**
                             * netty 心跳检查，IdleStateHandler，这个类可以对三种类型的心跳检测
                             * 1）readerIdleTime：为读超时时间（即测试端一定时间内未接受到被测试端消息）
                             * 2）writerIdleTime：为写超时时间（即测试端一定时间内向被测试端发送消息）
                             * 3）allIdleTime：所有类型的超时时间
                             *
                             * 在服务器端会每隔5秒来检查一下channelRead方法被调用的情况，如果在5秒内该链上的channelRead方法都没有被触发，
                             * 就会调用userEventTriggered方法：
                             *
                             * IdleStateHandler 核心在initialize(ctx);
                             * 启动读写超时检查任务
                             */
                            .addLast(new IdleStateHandler(5, 0,0, TimeUnit.SECONDS))
                            .addLast("decoder", new StringDecoder())
                            .addLast("encoder", new StringEncoder())
                            .addLast(new HeartBeatServerHandler())
                            .addLast(new ChannelInboundHandlerAdapter(){
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    System.out.println("netty server active");
                                }

                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    System.out.println("server receive msg : " + msg);
                                    ctx.writeAndFlush("I received you message " + ctx.channel().remoteAddress());
                                }
                            });
                        }
                    }).childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture future = server.bind().sync();
            System.out.println("server started , listen " + port);
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }

    public static void main(String[] args){
        new NettyIdleServer(8080).start();
    }
}
