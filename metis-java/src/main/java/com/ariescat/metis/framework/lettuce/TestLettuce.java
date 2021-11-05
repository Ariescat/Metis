package com.ariescat.metis.framework.lettuce;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisURI;
import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.api.sync.RedisStringCommands;

/**
 * @date 2021-11-05, 周五
 */
public class TestLettuce {

    public static void main(String[] args) {
        RedisURI redisUri = RedisURI.Builder
                .redis("127.0.0.1", 6379)
//                .withPassword("authentication")
                .withDatabase(2).build();
        RedisClient client = RedisClient.create(redisUri);

        // connection, 线程安全的长连接，连接丢失时会自动重连，直到调用 close 关闭连接。
        StatefulRedisConnection<String, String> connection = client.connect();

        // sync, 默认超时时间为 60s.
        RedisStringCommands<String, String> sync = connection.sync();
        sync.set("host", "note.ariescat.com");
        String value = sync.get("host");
        System.out.println(value);

        // close connection
        connection.close();

        // shutdown
        client.shutdown();
    }
}
