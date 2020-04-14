package com.heyi.netty.smartiot.decoder;

import com.heyi.netty.smartiot.model.SmartIotpower;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 自定义协议数据解析
 * @author Administrator
 *
 */
public class SmartIotEncoder extends MessageToByteEncoder<SmartIotpower> {

    @Override
    protected void encode(ChannelHandlerContext ctx, SmartIotpower msg, ByteBuf out) throws Exception {
        //写入消息SmartIot具体内容
//        68 AA AA AA AA AA AA 88 00 EC 16
        out.writeByte(SmartIotpower.START);
        out.writeByte(170);
        out.writeByte(170);
        out.writeByte(170);
        out.writeByte(170);
        out.writeByte(170);
        out.writeByte(170);
        out.writeByte(136);
        out.writeByte(0);
        out.writeByte(236);
        out.writeByte(SmartIotpower.END);
    }

}