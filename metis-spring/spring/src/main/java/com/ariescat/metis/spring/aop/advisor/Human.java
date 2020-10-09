package com.ariescat.metis.spring.aop.advisor;

import com.ariescat.metis.spring.aop.anno.MyAnnotation;

/**
 * @author Ariescat
 * @version 2020/3/6 17:05
 */
public class Human implements Sleepable {

    @Override
    @MyAnnotation
    public void sleep() {
        System.out.println("我要睡觉了！");
    }
}
