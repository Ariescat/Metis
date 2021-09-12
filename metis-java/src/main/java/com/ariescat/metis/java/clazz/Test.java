package com.ariescat.metis.java.clazz;

/**
 * @date 2021-09-09, 周四
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.ariescat.metis.java.clazz.ClazzBean");

//        Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass("com.ariescat.metis.base.clazz.ClazzBean");
    }
}
