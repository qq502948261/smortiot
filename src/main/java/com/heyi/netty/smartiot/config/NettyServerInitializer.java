package com.heyi.netty.smartiot.config;


import com.heyi.netty.smartiot.decoder.SmartIotDecoder;
import com.heyi.netty.smartiot.decoder.SmartIotEncoder;
import com.heyi.netty.smartiot.server.SmartIotHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 服务器初始化
 * @author Administrator
 *
 */
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
//        ch.pipeline().addLast("logging",new LoggingHandler("DEBUG"));//设置log监听器，并且日志级别为debug，方便观察运行流程
//        ch.pipeline().addLast("http-codec",new HttpServerCodec());//设置解码器
//        ch.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));//聚合器，使用websocket会用到
//        ch.pipeline().addLast("http-chunked",new ChunkedWriteHandler());//用于大数据的分区传输
//        ch.pipeline().addLast("handler",new SmartIotHandler());//自定义的业务handler
//        ChannelPipeline pipeline = ch.pipeline();
//        //自定义切割符
//        //ByteBuf delimiter = Unpooled.copiedBuffer(new byte[] {16});
//        ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
//
//        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, delimiter));
//        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
//        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
//        pipeline.addLast(new NettyServerHandler());

        ChannelPipeline pipeline = ch.pipeline();
        //添加自定义编解码器
        pipeline.addLast(new SmartIotEncoder());
        pipeline.addLast(new SmartIotDecoder());
        //处理网络IO
        pipeline.addLast(new SmartIotHandler());
    }

}