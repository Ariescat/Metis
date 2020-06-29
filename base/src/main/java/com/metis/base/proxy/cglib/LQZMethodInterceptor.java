package com.metis.base.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LQZMethodInterceptor implements MethodInterceptor {

    /**
     * @param o           cglib生成的代理对象
     * @param method      被代理对象方法
     * @param objects     方法入参
     * @param methodProxy 代理方法
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("intercept");
        return methodProxy.invokeSuper(o, objects);
    }
}
