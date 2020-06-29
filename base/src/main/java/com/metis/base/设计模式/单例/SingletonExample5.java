package com.metis.base.设计模式.单例;

import net.jcip.annotations.ThreadSafe;

/**
 * 1、懒汉模式，【双重同步锁单例模式 】，单例实例在第一次使用时进行创建
 * 2、此实现是，线程安全的，volatile禁止指令重排序。
 * 3、第二种，将对象的引用保存到volatile类型域或者AtomicReference对象中。
 *
 * @author Ariescat
 * @version 2020/6/29 19:30
 */
@ThreadSafe
public class SingletonExample5 {
    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    // 私有的默认构造方法，避免外部通过new创建对象。
    private SingletonExample5() {
    }

    // 定义单例对象，至少保证有一个对象被创建的。
    // 单例对象 volatile + 双重检测机制 -> 禁止指令重排
    // volatile适用场景做状态标识量、双重检测，此处就是volatile的双重检测使用场景。
    private volatile static SingletonExample5 singletonExample4 = null;

    // 静态工厂方法
    public static SingletonExample5 getInstance() {
        // 双重检测机制
        if (singletonExample4 == null) {
            // 同步锁，判断对象不为空以后，锁着SingletonExample4类
            // synchronized修饰的内部，同一时间只能由一个线程可以访问的。
            synchronized (SingletonExample5.class) {
                // 再次进行判断，如果singletonExample4为空，就进行创建对象。
                if (singletonExample4 == null) {
                    singletonExample4 = new SingletonExample5();
                }
            }
        }
        return singletonExample4;
    }
}