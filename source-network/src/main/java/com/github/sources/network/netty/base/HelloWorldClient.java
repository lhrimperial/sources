package com.github.sources.network.netty.base;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.text.SimpleDateFormat;

/**
 *
 */
public class HelloWorldClient {
    private static final String HOST = "127.0.0.1";
    private static final int PORT= 8080;

    public static void main(String[] args) throws Exception{
//        new HelloWorldClient().start(HOST, PORT);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.parse("2018-10-22 00:00:00").getTime());
        System.out.println(format.parse("2018-10-22 23:59:59").getTime());

        System.out.println(5000*14*3600);

        System.out.println(("logType=NORMAL|tip=success push message||responseStatus=200|convertTimeCost=8ms|pushTimeCost=55ms|message=id=6241884|" +
                "msgTokenId=6241882|msgId=76107780|msgTypeId=20|msgType=order|maxRetry=3|retryCount=0|token=024C875D784511E889D91866DAF32504|pushType=1" +
                "|pushUrl=http://agent.piao.qunar.com/adapter/lvmama2.qunar?method=pushOrder&identity=QUNA_TICKET|converterType=3|threhold=100|priority=5|" +
                "receiveTime=2018-10-12 16:09:13.000|isSpeedFast=true|rpcPusherId=null|convertMapId=5|encryptMethod=MD5|connectTimeOut=null|readTimeOut=null" +
                "|msgContent={\"approveStatus\":\"true\",\"waitPaymentTime\":\"\",\"money\":0,\"orderMoney\":7600,\"credentials\":[{\"goodsId\":11446574,\"" +
                "additional\":\"73722737\",\"serialCode\":\"\"}],\"orderId\":76107780,\"changeType\":\"CANCEL\",\"performStatus\":\"USED\",\"paymentStatus\"" +
                ":\"PAYED\",\"credenctStatus\":\"CREDENCE_NO_SEND\",\"status\":\"CANCEL\"}|responseContent=<?xml version=\"1.0\" encoding=\"UTF-8\" " +
                "standalone=\"yes\"?><response><state><code>1000</code><message>success</message></state></response>|requestHeader=null|requestBody=<?xml " +
                "version=\"1.0\" encoding=\"utf-8\" ?><request><header><signed>5d536ed2baac62e63a4ee6e39ca926b1</signed></header><body><order><orderId>76" +
                "107780</orderId><status>CANCEL</status><approveStatus>true</approveStatus><paymentStatus>PAYED</paymentStatus><waitPaymentTime></waitPay" +
                "mentTime><credenctStatus>CREDENCE_NO_SEND</credenctStatus><performStatus>USED</performStatus><credentials><credential><goodsId>11446574</g" +
                "oodsId><serialCode></serialCode><QRcode></QRcode><additional>73722737</additional></credential></credentials></order></body></request>").getBytes().length);
    }

    public void start(String host, int port) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap client = new Bootstrap().group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast("decoder", new StringDecoder())
                                    .addLast("encoder", new StringEncoder())
                                    .addLast(new HelloWorldClientHandler());
                        }
                    });
            ChannelFuture future = client.connect(host, port).sync();
            future.channel().writeAndFlush("Hello Netty Server ,I am a netty client");
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

        /**
         *
         */
    }

    public static class HelloWorldClientHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("HelloWorldClientHandler Active");
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("HelloWorldClientHandler read Message:"+msg);
        }
    }
}
