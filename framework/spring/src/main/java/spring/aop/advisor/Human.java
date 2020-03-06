package spring.aop.advisor;

/**
 * @author Ariescat
 * @version 2020/3/6 17:05
 */
public class Human implements Sleepable {

    @Override
    public void sleep() {
        System.out.println("我要睡觉了！");
    }
}
