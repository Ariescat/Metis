package jdk.hotswapagent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.LoaderClassPath;
import javassist.NotFoundException;
import jdk.hotswap.Person;

import java.io.IOException;

/**
 * 自己用javassist测试
 *
 * @author Ariescat
 * @version 2020/1/8 17:53
 */
public class MainTestInJavassist {
    public static void main(String[] args) throws Exception {
        Person p = new Person();  //内存只有一个实例对象
        new Thread(() -> {
            while (true) {
                try {
                    p.sayHello();
                    Thread.sleep(2000);

                    ClassLoader classLoader = MainTestInJavassist.class.getClassLoader();
                    CtClass ctClass = createCtClass(classLoader);

                    Class<?> clazz = classLoader.loadClass(ctClass.getName());
                    System.err.println("load...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     * Creats javaassist CtClass for bytecode manipulation. Add default classloader.
     * <p>
     * {@link org.hotswap.agent.annotation.handler.WatchEventCommand#createCtClass}
     */
    private static CtClass createCtClass(ClassLoader classLoader) throws NotFoundException, IOException {
        ClassPool cp = new ClassPool();
        cp.appendClassPath(new LoaderClassPath(classLoader));

        return cp.makeClass("jdk.hotswap.Person");
    }


}
