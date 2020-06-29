package com.metis.base.设计模式.单例;

import net.jcip.annotations.ThreadSafe;

/**
 * 1、饿汉模式，单例实例在类装载时进行创建，饿汉模式是线程安全的。
 * 2、饿汉模式，如果单例类构造方法中没有过多的操作处理，饿汉模式是可以接受的。
 * 3、饿汉模式的缺点，如果单例类构造方法中存在过多的操作处理，会导致该类加载的过慢。可能会引起性能问题。
 * 4、第一种，在静态初始化函数中初始化一个对象引用。
 *
 * @author Ariescat
 * @version 2020/6/29 19:27
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有的默认构造方法，避免外部通过new创建对象。
    // 饿汉模式，私有构造方法没有过多处理。饿汉模式创建的对象肯定会在实际中被使用，不会造成资源浪费。
    private SingletonExample2() {
    }

    // 定义单例对象，至少保证有一个对象被创建的。在类装载的时候进行创建保证了线程的安全性。
    private static SingletonExample2 singletonExample2 = new SingletonExample2();

    // 静态工厂方法
    public static SingletonExample2 getInstance() {
        return singletonExample2;
    }
}
