package com.ariescat.metis.designpatterns.singleton;

import net.jcip.annotations.ThreadSafe;

/**
 * 1、饿汉模式 ，单例实例在类装载时进行创建，饿汉模式是线程安全的。
 *
 * @author Ariescat
 * @version 2020/6/29 19:38
 */
@ThreadSafe
public class SingletonExample6 {

    // 私有的默认构造方法，避免外部通过new创建对象。
    // 饿汉模式，私有构造方法没有过多处理。饿汉模式创建的对象肯定会在实际中被使用，不会造成资源浪费。
    private SingletonExample6() {
    }

    // 定义单例对象，至少保证有一个对象被创建的。在类装载的时候进行创建保证了线程的安全性。
    private static SingletonExample6 singletonExample6 = null;

    // 静态块初始化对象singletonExample6
    static {
        singletonExample6 = new SingletonExample6();
    }

    // 静态工厂方法
    public static SingletonExample6 getInstance() {
        return singletonExample6;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }

}