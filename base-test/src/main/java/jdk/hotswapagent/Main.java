package jdk.hotswapagent;

import jdk.hotswap.Person;

/**
 * -XXaltjvm=dcevm -javaagent:libs\hotswap-agent-1.3.0.jar
 *
 * @author Ariescat
 * @version 2020/1/7 20:00
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Person p = new Person();  //内存只有一个实例对象
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    p.sayHello();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        ).start();

    }
}
