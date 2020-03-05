package jdk8.hashmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Ariescat
 * @version 2020/1/20 10:42
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        Thread t1 = new Thread(() -> {
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(2));
            map.computeIfAbsent(4, key -> {
                map.clear();
                System.out.println("4");
                return key;
            });
        });
        Thread t2 = new Thread(() -> {
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(2));
            map.computeIfAbsent(3, key -> {
                map.clear();
                System.out.println("3");
                return key;
            });
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("finish");
    }
}
