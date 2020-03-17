package com.metis.spring.aop.aspect;

/**
 * 定义切面
 *
 * @author Ariescat
 * @version 2020/3/6 17:22
 */
public class SleepHelperAspect {

    public void beforeSleep() {
        System.out.println("睡觉前要脱衣服！");
    }

    public void afterSleep() {
        System.out.println("起床后要穿衣服！");
    }
}

