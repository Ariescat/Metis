package spring.aop.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ariescat
 * @version 2020/3/6 17:13
 */
public class TestAdvisor {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop-advisor.xml");
        Sleepable human = (Sleepable) applicationContext.getBean("human");
        human.sleep();
    }
}
