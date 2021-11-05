package com.ariescat.metis.framework.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @date 2021-11-05, 周五
 */
public class TestTryLock {

    public static void main(String[] args) {
        // 构造redisson实现分布式锁必要的Config
        Config config = new Config();
        config
                .useSingleServer()
                .setAddress("redis://127.0.0.1:6379")
                // .setPassword("a123456")
                .setDatabase(1);
        // 构造RedissonClient
        RedissonClient redissonClient = Redisson.create(config);
        // 设置锁定资源名称
        RLock disLock = redissonClient.getLock("DISLOCK");
        boolean isLock;
        try {
            long id = Thread.currentThread().getId();
            System.err.println(id);
            //尝试获取分布式锁
            isLock = disLock.tryLock(500, 15000, TimeUnit.MILLISECONDS);
            if (isLock) {
                //TODO if get lock success, do something;
                Thread.sleep(13000);
            }
        } catch (Exception e) {
        } finally {
            // 无论如何, 最后都要解锁
            disLock.unlock();
        }
    }
}
