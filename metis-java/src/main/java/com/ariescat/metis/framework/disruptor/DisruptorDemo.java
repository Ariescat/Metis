package com.ariescat.metis.framework.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Ariescat
 * @version 2020/4/10 15:07
 */
public class DisruptorDemo {

    public static void main(String[] args) throws InterruptedException {
        //Executor将用来为消费者构建线程
        ExecutorService executor = Executors.newCachedThreadPool();

        //事件工厂用来创建事件
        PeopleEventFactory peopleEventFactory = new PeopleEventFactory();

        //指定Ring Buffer大小，2的倍数
//        int buffSize = 1024;
        int buffSize = 2;

        /**
         * 构造Disruptor
         * 并发系统提高性能之一就是单一写者原则，如果代码中仅有一个事件生产者，可以设置单一生产者模式来提高系统的性能。
         * 通过ProduceType.SINGLE和ProduceType.MULTI进行控制。
         *
         * 等待策略
         * Disruptor默认的等待策略是BlockingWaitStrategy，使用一个锁和条件变量来控制执行和等待，这是最慢的策略，但也是CPU使用最低
         * 和最稳定的策略。
         * SleepingWaitStrategy：也是CPU使用率低的策略，它使用循环等待并且循环间调用LockSupport.parkNanos(1)来睡眠。它的优点在于
         * 生产线程只需记数，而不执行任何命令，并且没有条件变量的消耗。但是对象从生产者到消费者传递延迟变大了，适用于不需要低延迟的场景，
         * YieldingWaitStrategy：是可以被用作低延迟系统的两个策略之一，这种策略在低延迟同时会增加CPU运算量。YieldingWaitStrategy
         * 会循环等待sequence增加到合适值，循环调用Tread.yield()允许其它准备好的线程执行。如果高性能而且事件消费者线程比逻辑内核少的
         * 时候，推荐使用YieldingWaitStrategy策略。
         * BusySpinWaitStrategy是性能最高的策略，同时也是对部署环境要求最高的策略。这个策略最好用在时间处理线程比物理内核数目还要少的时候。
         */
        Disruptor<PeopleEvent> disruptor = new Disruptor<PeopleEvent>(peopleEventFactory, buffSize, executor,
                ProducerType.SINGLE, new YieldingWaitStrategy());

        //链接处理器
        disruptor.handleEventsWith(new PeopleEventHandler());

        //启动Disruptor，启动所有线程
        disruptor.start();

        //从Disruptor获取RingBuffer，用来发布
        RingBuffer<PeopleEvent> ringBuffer = disruptor.getRingBuffer();

        PeopleEventProducer producer = new PeopleEventProducer(ringBuffer);

        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", "yjz" + i);
            map.put("age", 25 + i);
            map.put("sex", 1);

            producer.onData(map);
        }

        TimeUnit.SECONDS.sleep(1L);
        disruptor.shutdown();

        TimeUnit.SECONDS.sleep(1L);
        executor.shutdown();

        System.out.println("finish.");
    }
}
