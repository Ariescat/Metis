package com.metis.groovy.withJava;

import com.metis.base.math.round.Main;

public class TestGroovy2 implements ITestGroovy2 {

    @Override
    public void print(String msg) {
        System.out.println(msg);

        // 直接抛出异常
//        throw new RuntimeException("pppp");

        // 调用本类方法
//        testCall();

        // 调用其他类方法
        Main.main(null);
    }

    private void testCall() {
//        new TestGroovy().printArgs("1", "2", "3");
        throw new RuntimeException("testCall");
    }

}
