package com.metis.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LQZHandler implements InvocationHandler {

    private Object object;

    public LQZHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("before");
        return method.invoke(object, args);
    }
}
