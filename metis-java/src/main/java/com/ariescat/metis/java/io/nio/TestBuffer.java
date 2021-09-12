package com.ariescat.metis.java.io.nio;

import java.nio.IntBuffer;

/**
 * @author Ariescat
 * @version 2020/3/17 19:27
 */
public class TestBuffer {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(1);
        buffer.put(2);
        buffer.flip();
        System.err.println(buffer.get());
        System.err.println(buffer.get());
    }
}
