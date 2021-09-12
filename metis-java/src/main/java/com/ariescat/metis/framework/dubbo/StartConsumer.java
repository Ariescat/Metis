package com.ariescat.metis.framework.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ariescat
 * @version 2020/4/28 11:56
 */
public class StartConsumer {

    public static void main(String[] args) throws InterruptedException {
//        System.setProperty(SpringContainer.SPRING_CONFIG, "spring/dubbo-consumer.xml");
//        org.apache.dubbo.container.Main.main(args);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        context.start();

        IDubboHello ref = (IDubboHello) context.getBean("dubboHelloRef");
        System.out.println(ref);

        ref.say();
    }

}
