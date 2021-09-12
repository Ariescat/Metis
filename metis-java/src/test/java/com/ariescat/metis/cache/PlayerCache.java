package com.ariescat.metis.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试happen-before原则
 *
 * @author Ariescat
 * @version 2021/1/14
 */
public class PlayerCache {
    private final static Map<String, Player> playerCache = new HashMap<>();
    private static volatile long num = 0;

    //static volatile  int a = 1;

    static private boolean initialized = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            System.err.println("start1");
            doWork();
        }).start();

        Thread.sleep(1000);

        new Thread(() -> init()).start();
    }

    public static void init() {
        initialized = true;
        //a = 2;
    }

    public static void doWork() {
        while (!initialized && Thread.interrupted()) {
            //int b = a;
        }
        System.out.println("end loop");
    }

    private PlayerCache() {
        throw new RuntimeException("the PlayerHelper cannot be instantiated!");
    }

    public static Player getPlayer(String account) {
        Player player;
        if (num > 0) { //1
            player = playerCache.get(account); //2
            if (player == null) {
                synchronized (playerCache) {
                    player = playerCache.get(account);
                    if (player == null) {
                        player = Player.valueOf();
                        playerCache.put(account, player); //3
                        num++;
                    }
                }
            }
        } else {
            synchronized (playerCache) {
                player = playerCache.get(account);
                if (player == null) {
                    player = Player.valueOf();
                    playerCache.put(account, player);
                    num++;
                }
            }
        }
        return player;
    }

    static class Player {
        public static Player valueOf() {
            // 假设这里是个复杂对象，方法耗时较长
            return new Player();
        }
    }
}
