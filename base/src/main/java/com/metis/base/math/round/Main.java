package com.metis.base.math.round;

public class Main {

    public static void main(String[] args) {
        /**
         * Math.round(1.5)的返回值是2，Math.round(-1.5)的返回值是-1。四舍五入的原理是在参数上加0.5然后做向下取整。
         */
        System.err.println(Math.round(-1.5));
    }
}
