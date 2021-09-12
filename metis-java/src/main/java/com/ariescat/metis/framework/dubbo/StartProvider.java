package com.ariescat.metis.framework.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author Ariescat
 * @version 2020/4/28 11:56
 */
public class StartProvider {

    public static IDubboHello dubboHello;

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-provider.xml");
        context.start();

        int read = System.in.read();
    }

}
