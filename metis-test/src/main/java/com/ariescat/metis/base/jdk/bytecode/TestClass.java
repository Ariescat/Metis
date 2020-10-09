package com.ariescat.metis.base.jdk.bytecode;

/**
 * 查看字节码的文件结构
 *
 * @author Ariescat
 * @version 2019/12/31 10:02
 */
public class TestClass {

    private int m;

    public int inc() {
        return m + 1;
    }

    public int inctry() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}
