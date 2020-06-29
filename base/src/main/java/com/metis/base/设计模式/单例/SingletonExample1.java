package com.metis.base.设计模式.单例;

import net.jcip.annotations.NotThreadSafe;

/**
 * https://www.cnblogs.com/biehongli/p/12157170.html
 * <pre>
 * 1、安全发布对象的发布与逃逸。
 *
 * 　　发布对象，使一个对象能够被当前范围之外的代码所使用。
 *
 * 　　对象逸出，一种错误的发布，当一个对象还没有构造完成时，就使它被其他线程所见。
 *
 * 　　如果不正确的发布了可变对象，会造成两种错误，首先是发布线程以外的任何线程都可以看到被发布对象的过期的值。其次呢，线程看到的被发布对象的引用是最新的，然而呢，被发布对象的状态却是过期的，如果一个对象是可变对象，那么它就要被安全发布才可以。
 *
 * 2、安全发布对象的四种方式。
 *
 * 　　1）、第一种，在静态初始化函数中初始化一个对象引用。
 * 　　2）、第二种，将对象的引用保存到volatile类型域或者AtomicReference对象中。
 * 　　3）、第三种，将对象的引用保存到某个正确构造对象的final类型域中。
 * 　　4）、第四种，将对象的引用保存到一个由锁保护的域中。
 * </pre>
 *
 *
 * 1、懒汉模式 ，单例实例在第一次使用时进行创建
 * 2、单线程运行没有问题的，但是多线程可能在getInstance出现线程不安全的情况
 * 3、第一种，在静态初始化函数中初始化一个对象引用。
 *
 * @author Ariescat
 * @version 2020/6/29 19:07
 */
@NotThreadSafe
public class SingletonExample1 {

    // 私有的默认构造方法，避免外部通过new创建对象。
    private SingletonExample1() {
    }

    // 定义单例对象，至少保证有一个对象被创建的。
    private static SingletonExample1 singletonExample1 = null;

    // 静态工厂方法
    public static SingletonExample1 getInstance() {
        // 判断对象是否为null和创建对象，此处导致了线程不安全
        if (null == singletonExample1) {
            singletonExample1 = new SingletonExample1();
        }
        return singletonExample1;
    }
}