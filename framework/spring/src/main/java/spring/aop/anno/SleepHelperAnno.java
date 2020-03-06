package spring.aop.anno;

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

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void doThrowing(Exception e) {
        System.out.println("Exception" + e.getMessage());
    }
}
