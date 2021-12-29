package com.ariescat.metis.java.base.operator.and;

/**
 * 数据结构与算法中有那些奇技淫巧？
 * <p>
 * <p>
 * 用 n & (n - 1)消去 n 最后的一位 1
 * <p>
 * <p>
 * 在 n 的二进制表示中，如果我们对 n 执行
 * n = n & (n - 1)
 * 那么可以把 n 左右边的 1 消除掉，例如
 * n = 1001
 * n - 1 = 1000
 * n = n & (n - 1) = (1001) & (1000) = 1000
 * 复制代码这个公式有哪些用处呢？
 * 其实还是有挺多用处的，在做题的时候也是会经常碰到，下面我列举几道经典、常考的例题。
 *
 * @link https://juejin.im/post/5d208491f265da1ba56b3f3a
 */
public class Main {

    public static void main(String[] args) {
        int n = 4;
        int i = n & (n - 1);
        System.err.println(i == 0);

        // 一个f有4位，一个int有32位
        System.err.println(0x7FFFFFFF);
        System.err.println(Integer.MAX_VALUE);
    }
}
