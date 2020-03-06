package spring.aop.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aop.advisor.Sleepable;

/**
 * @author Ariescat
 * @version 2020/3/6 17:13
 */
public class TestAspect {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop-aspect.xml");
        Sleepable human = (Sleepable) applicationContext.getBean("human");
        human.sleep();
    }
}
