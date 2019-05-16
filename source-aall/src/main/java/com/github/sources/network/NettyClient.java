package com.github.sources.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/** */
public class NettyClient {

    public static void main(String[] args) {
        new NettyClient().start("127.0.0.1", 8080);
    }

    public void start(String host, int port) {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap client =
                    new Bootstrap()
                            .group(group)
                            .channel(NioSocketChannel.class)
                            .option(ChannelOption.TCP_NODELAY, true)
                            .handler(
                                    new ChannelInitializer<SocketChannel>() {
                                        @Override
                                        protected void initChannel(SocketChannel ch)
                                                throws Exception {
                                            ch.pipeline()
                                                    .addLast("decode", new StringDecoder())
                                                    .addLast("encode", new StringEncoder())
                                                    .addLast(new ClientHandler());
                                        }
                                    });
            ChannelFuture future = client.connect(host, port).sync();
            future.channel().writeAndFlush("Hello Netty Server ,I am a netty client");
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static class ClientHandler extends ChannelInboundHandlerAdapter {
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("NettyClient Active");
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("NettyClient read Message:" + msg);
        }
    }
}
