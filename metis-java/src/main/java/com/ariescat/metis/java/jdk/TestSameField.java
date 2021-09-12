package com.ariescat.metis.java.jdk;

/**
 * @link https://blog.csdn.net/qq_36382679/article/details/105811529
 */
public class TestSameField {
    public static void main(String[] args) {
//        A son = new B();
//        5 ----> j=0
//        1 ----> j=2
//        10 ----> j=0
//        6 ----> j=4
//        3 ----> j=2
//        4 ----> i=0 j=2
//        2 ----> i=1 j=2
//        9 ----> i=0 j=4
//        8 ----> i=3 j=4
//        7 ----> i=3 j=4

        B son2 = new B();
//        5 ----> j=0
//        1 ----> j=2
//        10 ----> j=0
//        6 ----> j=4
//        3 ----> j=2
//        4 ----> i=0 j=2
//        2 ----> i=1 j=2
//        9 ----> i=0 j=4
//        8 ----> i=3 j=4
//        7 ----> i=3 j=4
    }
}

class A {
    {
        System.out.println("3 ----> j=" + j);
    }

    private int i = test();
    private static int j = method();

    static {
        System.out.println("1 ----> j=" + j);
    }

    A() {
        System.out.println("2 ----> i=" + i + " j=" + j);
    }


    private int test() {
        System.out.println("4 ----> i=" + i + " j=" + j);
        return 1;
    }

    private static int method() {
        System.out.println("5 ----> j=" + j);
        return 2;
    }
}

class B extends A {
    private int i = test();
    private static int j = method();

    static {
        System.out.println("6 ----> j=" + j);
    }

    B() {
        System.out.println("7 ----> i=" + i + " j=" + j);
    }

    {
        System.out.println("8 ----> i=" + i + " j=" + j);
    }

    private int test() {
        System.out.println("9 ----> i=" + i + " j=" + j);
        return 3;
    }

    private static int method() {
        System.out.println("10 ----> j=" + j);
        return 4;
    }

}
