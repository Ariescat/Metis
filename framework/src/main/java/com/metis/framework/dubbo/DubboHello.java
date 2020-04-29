package com.metis.framework.dubbo;

/**
 * @author Ariescat
 * @version 2020/4/28 15:49
 */
public class DubboHello implements IDubboHello {

    @Override
    public void say() {
        System.out.println("Ariescat say: hello!");
    }
}
