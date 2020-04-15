package com.heyi.netty.smartiot.server;

import java.net.InetSocketAddress;

import com.heyi.netty.smartiot.Utils.ConvertCode;
import com.heyi.netty.smartiot.model.SmartIotpower;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.StringUtils;

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

    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.fireChannelRead(msg);
        System.out.println(msg.toString());
        System.out.println("2312321321321312321321321");

        if(msg!= null) {
//            ByteBuf time = ctx.alloc().buffer(4); //为ByteBuf分配四个字节
//            time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
            ByteBuf byteBuf = ctx.alloc().buffer(11);//为bytebuf分配11个字节
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
            System.out.println("发送了68 AA AA AA AA AA AA 88 00 EC 16");
        }
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
    private ChannelHandlerContext ctx;
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    public void send(String msg) {
        ctx.writeAndFlush(msg);
    }

    }

