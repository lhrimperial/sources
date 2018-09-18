package com.github.sources.network.netty.codec;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 *
 */
public class NettyCodecClient {

    private static final String host = "127.0.0.1";
    private static final int port = 8080;

    public void connect(String host, int port) {
        NioEventLoopGroup worker = new NioEventLoopGroup();

        try {
            Bootstrap client = new Bootstrap().group(worker).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast("decoder", new StringDecoder())
                                    .addLast("encoder", new StringEncoder())
                                    .addLast(new ChannelInboundHandlerAdapter(){
//                                        byte[] req = "BazingaLyncc is learner".getBytes();

                            //        req = ("BazingaLyncc is learner" + System.getProperty("line.separator"))
                            //            .getBytes();
                                        byte[] req = ("In this chapter you general, we recommend Java Concurrency in Practice by Brian Goetz. His book w"
                                                + "ill give We’ve reached an exciting point—in the next chapter we’ll discuss bootstrapping, the process "
                                                + "of configuring and connecting all of Netty’s components to bring your learned about threading models in ge"
                                                + "neral and Netty’s threading model in particular, whose performance and consistency advantages we discuss"
                                                + "ed in detail In this chapter you general, we recommend Java Concurrency in Practice by Brian Goetz. Hi"
                                                + "s book will give We’ve reached an exciting point—in the next chapter we’ll discuss bootstrapping, the"
                                                + " process of configuring and connecting all of Netty’s components to bring your learned about threading "
                                                + "models in general and Netty’s threading model in particular, whose performance and consistency advantag"
                                                + "es we discussed in detailIn this chapter you general, we recommend Java Concurrency in Practice by Bri"
                                                + "an Goetz. His book will give We’ve reached an exciting point—in the next chapter;the counter is: 1 2222"
                                                + "sdsa ddasd asdsadas dsadasdas" + System.getProperty("line.separator")).getBytes();

                                        @Override
                                        public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                            ByteBuf message = null;

//                                            for (int i = 0; i < 100; i++) {
//                                                message = Unpooled.buffer(req.length);
//                                                message.writeBytes(req);
//                                                ctx.writeAndFlush(message);
//                                            }

                                            message = Unpooled.buffer(req.length);
                                            message.writeBytes(req);
                                            ctx.writeAndFlush(message);
                                            message = Unpooled.buffer(req.length);
                                            message.writeBytes(req);
                                            ctx.writeAndFlush(message);
                                        }

                                        @Override
                                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                            String buf = (String) msg;
                                            System.out.println("Now is : " + buf);
                                        }
                                    });
                        }
                    });
            ChannelFuture future = client.connect(host, port).sync();
            future.channel().writeAndFlush("Hello Netty Server ,I am a common client");
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            worker.shutdownGracefully();
        }

    }

    public static void main(String[] args){
        new NettyCodecClient().connect(host, port);
    }
}
