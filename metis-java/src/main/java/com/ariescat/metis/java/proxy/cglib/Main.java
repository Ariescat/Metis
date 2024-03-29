package com.ariescat.metis.java.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

import java.net.URL;

public class Main {

    /**
     * @link https://blog.csdn.net/yhl_jxy/article/details/80633194
     */
    public static void main(String[] args) {
        URL url = Main.class.getResource("");
        String path = url.getPath();
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, path);
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(Hello.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new LQZMethodInterceptor());
        // 创建代理对象
        Hello proxy = (Hello) enhancer.create();
        // 通过代理对象调用目标方法
        proxy.sayHello();
    }
}
