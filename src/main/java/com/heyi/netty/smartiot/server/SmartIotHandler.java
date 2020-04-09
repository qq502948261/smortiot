package com.heyi.netty.smartiot.server;

import java.net.InetSocketAddress;

import com.heyi.netty.smartiot.model.SmartIotpower;
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
//
//        log.info("收到设备数据包: " + iot.getFlowid());
//        iot.printDebugInfo();
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
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}