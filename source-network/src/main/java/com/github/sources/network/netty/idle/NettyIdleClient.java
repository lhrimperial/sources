package com.github.sources.network.netty.idle;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class NettyIdleClient {
    private static final String host = "127.0.0.1";
    private static final int port = 8080;

    public void connect(String host, int port) {
        NioEventLoopGroup worker = new NioEventLoopGroup();
        ChannelFuture future = null;

        try {
            Bootstrap client = new Bootstrap().group(worker).channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress(host,port))
                    .option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast(new IdleStateHandler(0, 4, 0, TimeUnit.SECONDS))
                                    .addLast(new StringDecoder())
                                    .addLast(new StringEncoder())
                                    .addLast(new HeartBeatClientHandler())
                                    .addLast(new ChannelInboundHandlerAdapter() {
                                        @Override
                                        public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                            System.out.println("netty client handler active");
                                        }

                                        @Override
                                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                            System.out.println("client receive message : " + msg);
                                        }
                                    });
                        }
                    });
            System.out.println("connect to server....");
            future = client.connect().sync();
            System.out.println("send message to server....");
            future.channel().writeAndFlush("hello netty server!");
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != future) {
                if (future.channel() != null && future.channel().isOpen()) {
                    future.channel().close();
                }
            }
            System.out.println("准备重连");
            connect(host, port);
            System.out.println("重连成功");
        }
    }

    public static void main(String[] args){
        new NettyIdleClient().connect(host, port);
    }
}
