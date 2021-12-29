package com.ariescat.metis.java.clazz;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date 2021-12-28, 周二
 */
public class TestClassLayout {

    public static void main(String[] args) {
//        System.out.println(ClassLayout.parseInstance(new Integer(5)).toPrintable());
//        System.out.println(ClassLayout.parseInstance(5).toPrintable());
//        System.out.println(ClassLayout.parseInstance(new Long(5)).toPrintable());
//
//        int[][] arr1 = new int[128][2];
//        for (int[] arr : arr1) {
//            Arrays.fill(arr, 1);
//        }
//        System.out.println(ClassLayout.parseInstance(arr1).toPrintable());
//        int[] arr2 = new int[256];
//        Arrays.fill(arr2, 1);
//        System.out.println(ClassLayout.parseInstance(arr2).toPrintable());

        System.out.println(ClassLayout.parseInstance(new X()).toPrintable());
    }

    static class X { // 8 字节-指向 class 定义的引用
        int a; // 4 字节
        double d; // 4 字节
        byte b; // 1 字节
        byte b1; // 1 字节
        Integer c = new Integer(4); // 4 字节的引用
        int a1; // 4 字节
        byte b2; // 1 字节
    }
}
