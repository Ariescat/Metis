package com.ariescat.metis.designpatterns.singleton;

import net.jcip.annotations.ThreadSafe;

/**
 * 1、懒汉模式 ，单例实例在第一次使用时进行创建
 * 2、方法加synchronized修饰，不推荐，虽然保证了线程安全性，但是带来了性能方面的开销。
 * 3、第四种，将对象的引用保存到一个由锁保护的域中。
 *
 * @author Ariescat
 * @version 2020/6/29 19:28
 */
@ThreadSafe
public class SingletonExample3 {

    // 私有的默认构造方法，避免外部通过new创建对象。
    private SingletonExample3() {
    }

    // 定义单例对象，至少保证有一个对象被创建的。
    private static SingletonExample3 singletonExample3 = null;

    // 静态工厂方法
    // 使用synchronized修饰，方法内部所有实现同一时间内只能由一个线程访问。
    // 因此可以保证线程安全的。
    public static synchronized SingletonExample3 getInstance() {
        if (null == singletonExample3) {
            singletonExample3 = new SingletonExample3();
        }
        return singletonExample3;
    }
}
