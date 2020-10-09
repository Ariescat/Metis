package com.ariescat.metis.spring.aop.factory;

import com.ariescat.metis.spring.aop.advisor.Human;
import com.ariescat.metis.spring.aop.advisor.Sleepable;
import com.ariescat.metis.spring.aop.anno.SleepHelperAnno;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @author Ariescat
 * @version 2020/3/6 18:08
 */
public class SleepFactory {

    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new Human());
        weaver.addAspect(SleepHelperAnno.class);
        Object proxy = weaver.getProxy();
        ((Sleepable) proxy).sleep();
    }
}
