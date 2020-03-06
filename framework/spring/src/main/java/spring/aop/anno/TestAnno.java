package spring.aop.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aop.advisor.Sleepable;

/**
 * @author Ariescat
 * @version 2020/3/6 17:56
 */
public class TestAnno {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop-anno.xml");
        Sleepable human = (Sleepable) applicationContext.getBean("human");
        human.sleep();
    }
}
