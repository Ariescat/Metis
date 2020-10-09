package com.ariescat.metis.framework.netty.handle;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;

/**
 * create by 尼恩 @ 疯狂创客圈
 **/
public class OutHandlerDemoTester {

    public static void main(String[] args) {
        final OutHandlerDemo handler = new OutHandlerDemo();
        ChannelInitializer i = new ChannelInitializer<EmbeddedChannel>() {
            protected void initChannel(EmbeddedChannel ch) {
                ch.pipeline().addLast(handler);
            }
        };

        EmbeddedChannel channel = new EmbeddedChannel(i);

//        channel.pipeline().addLast(handler);

        //测试出站写入

        ByteBuf buf = Unpooled.buffer();
        buf.writeInt(1);

        ChannelFuture f = channel.pipeline().writeAndFlush(buf);
        f.addListener((future) -> {
            if (future.isSuccess()) {
                System.out.println("write is finished");
            }
            channel.close();
        });

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
