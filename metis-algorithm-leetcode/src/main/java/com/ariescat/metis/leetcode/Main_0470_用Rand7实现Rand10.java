package com.ariescat.metis.leetcode;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/**
 * https://leetcode-cn.com/problems/implement-rand10-using-rand7/
 */
public class Main_0470_用Rand7实现Rand10 {

    public static void main(String[] args) {
        System.err.println("test_rand10:");
        test_randN(Main_0470_用Rand7实现Rand10::rand10);
        System.err.println("test_rand7:");
        test_randN(Main_0470_用Rand7实现Rand10::_rand7_);
        System.err.println("test_rand10_2:");
        test_randN(Main_0470_用Rand7实现Rand10::rand10_from_8);
    }

    private static void test_randN(Supplier<Integer> supplier) {
        Map<Integer, Integer> counts = new TreeMap<>();
        for (int i = 0; i < 10000000; i++) {
            counts.compute(supplier.get(), (key, oldValue) -> {
                if (oldValue == null) {
                    oldValue = 0;
                }
                return ++oldValue;
            });
        }
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            System.err.println(entry.getKey() + " -- > " + entry.getValue());
        }
    }

    // -----------------------------------------------------------------------------------------------

    /**
     * 从 rand7() 到 rand10()
     * <p>
     * https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/xiang-xi-si-lu-ji-you-hua-si-lu-fen-xi-zhu-xing-ji/
     */
    public static int rand10() {
        // 首先得到一个数
        int num = (rand7() - 1) * 7 + rand7();
        // 只要它还大于40，那你就给我不断生成吧
        while (num > 40)
            num = (rand7() - 1) * 7 + rand7();
        // 返回结果，+1是为了解决 40%10为0的情况
        return 1 + num % 10;
    }

    private static int rand7() {
        return ThreadLocalRandom.current().nextInt(1, 8);
    }

    // -----------------------------------------------------------------------------------------------

    public static int rand10_from_8() {
        int num = (rand8() - 1) * 8 + rand8();
        // 0  1  2  3  4  5  6  7
        // 0  8 16 26 32 40 48 56  +  1  2  3  4  5  6  7  8
        while (num > 60)
            num = (rand8() - 1) * 8 + rand8();
        return 1 + num % 10;
    }

    private static int rand8() {
        return ThreadLocalRandom.current().nextInt(1, 9);
    }

    // -----------------------------------------------------------------------------------------------

    /**
     * 从 rand10() 到 rand7()
     */
    private static int _rand7_() {
        int random;
        while ((random = _rand10_()) > 7) ;
        return random;
    }

    private static int _rand10_() {
        return ThreadLocalRandom.current().nextInt(1, 11);
    }
}
