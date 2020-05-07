package com.metis.spring.aop.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author Ariescat
 * @version 2020/3/6 17:52
 */
@Aspect
public class SleepHelperAnno {

    @Pointcut("execution(* *.sleep(..))")
    private void pointcut() {
    }

    @Before("pointcut()")
    public void beforeSleep() {
        System.out.println("睡觉前要脱衣服！");
    }

    @After("pointcut()")
    public void afterSleep() {
        System.out.println("起床后要穿衣服！");
    }

    //定义增强，pointcut连接点使用@annotation（xxx）进行定义
    @Around(value = "@annotation(around)") //around 与 下面参数名around对应
    public void aroundSleep(ProceedingJoinPoint point, MyAnnotation around) throws Throwable {
        System.out.println("ANNOTATION welcome");
        System.out.println("ANNOTATION 调用方法：" + around.methodName());
        System.out.println("ANNOTATION 调用类：" + point.getSignature().getDeclaringTypeName());
        System.out.println("ANNOTATION 调用类名" + point.getSignature().getDeclaringType().getSimpleName());
        point.proceed(); //调用目标方法
        System.out.println("ANNOTATION login success");
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void doThrowing(Exception e) {
        System.out.println("Exception" + e.getMessage());
    }
}
