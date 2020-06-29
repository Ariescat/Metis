package com.metis.base.设计模式.单例;

import net.jcip.annotations.ThreadSafe;

/**
 * 1、枚举方式。线程安全，推荐的方式。
 * 2、相比于懒汉模式，在安全性方面更容易保证，在饿汉模式，在安全性方面，在实际调用方面才可以初始化，不会造成资源的浪费。
 *
 * @author Ariescat
 * @version 2020/6/29 19:39
 */
@ThreadSafe
public class SingletonExample7 {
    // 私有的默认构造方法，避免外部通过new创建对象。
    private SingletonExample7() {
    }

    // 静态工厂方法
    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    // 枚举类，私有的枚举类。
    private enum Singleton {
        // instance
        INSTANCE;

        // 私有的类的实例
        private SingletonExample7 singletonExample7;

        // JVM保证这个方法绝对只调用一次
        // 枚举类的构造方法
        Singleton() {
            singletonExample7 = new SingletonExample7();
        }

        // 提供一个方法方便类来获取
        public SingletonExample7 getInstance() {
            // 返回枚举类里面的实例
            return singletonExample7;
        }
    }
}

