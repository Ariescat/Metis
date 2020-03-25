package com.metis.framework.netty.buffer;

import com.metis.framework.Logger;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class Test {

    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer();
        Logger.info("after create:" + buffer.refCnt());
        buffer.retain();
        Logger.info("after retain:" + buffer.refCnt());
        buffer.release();
        Logger.info("after release:" + buffer.refCnt());
        buffer.release();
        Logger.info("after release:" + buffer.refCnt());
        //错误:refCnt: 0,不能再retain
        buffer.writeInt(5);
        buffer.retain();
        Logger.info("after retain:" + buffer.refCnt());
    }
}
