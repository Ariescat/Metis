package spring.aop.advisor;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 定义通知
 *
 * @author Ariescat
 * @version 2020/3/6 17:05
 */
public class SleepHelper implements MethodBeforeAdvice, AfterReturningAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("睡觉前要脱衣服！");
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("起床后要穿衣服！");
    }
}

