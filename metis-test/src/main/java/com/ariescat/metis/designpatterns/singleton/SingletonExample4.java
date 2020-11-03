package com.ariescat.metis.designpatterns.singleton;

import net.jcip.annotations.NotThreadSafe;

/**
 * 1、懒汉模式，【双重同步锁单例模式 】，单例实例在第一次使用时进行创建
 * 2、此实现是，线程不安全的，JVM和cpu优化，发生了指令重排
 *
 * @author Ariescat
 * @version 2020/6/29 19:29
 */
@NotThreadSafe
public class SingletonExample4 {

    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    // JVM和cpu优化，发生了指令重排

    // 1、memory = allocate() 分配对象的内存空间
    // 3、instance = memory 设置instance指向刚分配的内存
    // 2、ctorInstance() 初始化对象

    // 私有的默认构造方法，避免外部通过new创建对象。
    private SingletonExample4() {
    }

    // 定义单例对象，至少保证有一个对象被创建的。
    private static SingletonExample4 singletonExample4 = null;

    // 静态工厂方法
    public static SingletonExample4 getInstance() {
        // 双重检测机制
        if (singletonExample4 == null) {
            // 同步锁，判断对象不为空以后，锁着SingletonExample4类
            // synchronized修饰的内部，同一时间只能由一个线程可以访问的。
            synchronized (SingletonExample4.class) {
                // 再次进行判断，如果singletonExample4为空，就进行创建对象。
                if (singletonExample4 == null) {
                    singletonExample4 = new SingletonExample4();
                }
            }
        }
        return singletonExample4;
    }
}