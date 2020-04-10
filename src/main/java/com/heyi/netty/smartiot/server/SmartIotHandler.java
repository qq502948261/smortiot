package com.heyi.netty.smartiot.server;

import java.net.InetSocketAddress;

import com.heyi.netty.smartiot.model.SmartIotpower;
import io.netty.buffer.ByteBuf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 服务Handler 处理
 * @author Administrator
 *
 */
public class SmartIotHandler extends SimpleChannelInboundHandler<SmartIotpower> {


    private static final Logger log = LoggerFactory.getLogger(SmartIotHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SmartIotpower iot)
            throws Exception {

        log.info("收到设备数据包: " );
    //       ` iot.printDebugInfo();`
        ctx.write("ok");
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.fireChannelRead(msg);
        System.out.println(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress socket = (InetSocketAddress) ctx.channel().remoteAddress();
        String ip = socket.getAddress().getHostAddress();
        log.info("收到客户端IP: " + ip);

        while (true) {
//            ByteBuf time = ctx.alloc().buffer(4); //为ByteBuf分配四个字节
//            time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
            ByteBuf byteBuf = ctx.alloc().buffer(11);
            byteBuf.writeByte(SmartIotpower.START);
            byteBuf.writeByte(170);
            byteBuf.writeByte(170);
            byteBuf.writeByte(170);
            byteBuf.writeByte(170);
            byteBuf.writeByte(170);
            byteBuf.writeByte(170);
            byteBuf.writeByte(170);
            byteBuf.writeByte(136);
            byteBuf.writeByte(0);
            byteBuf.writeByte(236);
            byteBuf.writeByte(SmartIotpower.END);
            ctx.writeAndFlush(byteBuf); // (3)
            Thread.sleep(30000);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}