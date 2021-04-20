package com.ariescat.metis.base.jdk.system;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * System.exit(0) 结束不了其他线程
 *
 * @link https://bbs.csdn.net/topics/392009252
 */
public class Main {

    public static void main(String[] args) {
        AtomicInteger countA = new AtomicInteger();
        Thread tA = new Thread(() -> {
//            while (true) {
                System.out.println("第" + countA.incrementAndGet() + "次进来");
                for (int i = 0; i < 50; i++) {
                    if (i % 10 == 0)
                        System.out.println("线程A " + i);
                }
//            }
        });
        Thread tB = new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            for (int i = 0; i < 50; i++) {
                System.out.println("线程B " + i);
                if (i == 33) {
                    System.out.println("程序强制退出");
                    System.exit(0);
                }
            }
        });
        tA.start();
        tB.start();
    }
}
