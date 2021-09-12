package com.ariescat.metis.framework.jedis;

import redis.clients.jedis.Jedis;

/**
 * @author Ariescat
 * @version 2020/4/2 11:49
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start...");
        try (Jedis jedis = new Jedis("192.168.206.128", 6379)) {
            System.out.println("服务正在运行: " + jedis.ping());
            System.out.println(jedis.set("runoobkey1", "www.runoob.com"));
            System.out.println(jedis.set("runoobkey2", "www.runoob.com"));
            System.out.println(jedis.setnx("runoobkey3", "www.runoob.com"));
            System.out.println(jedis.keys("*"));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("sleep 1000ms start...");
            Thread.sleep(1000);
        }
    }
}
