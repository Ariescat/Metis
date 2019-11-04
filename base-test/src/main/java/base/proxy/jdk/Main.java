package base.proxy.jdk;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import static sun.misc.ProxyGenerator.generateProxyClass;

public class Main {

    /**
     * @link https://www.cnblogs.com/zuidongfeng/p/8735241.html
     */
    public static void main(String[] args) throws Exception {
        // 保存生成的代理类的字节码文件，代理类的字节码内容保存在了项目根目录下，文件名为$Proxy0.class
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        IHi hi = new Hi();
        InvocationHandler handler = new LQZHandler(hi);

        Object instance = Proxy.newProxyInstance(hi.getClass().getClassLoader(), hi.getClass().getInterfaces(), handler);
//        instance.hi();
        Class<?> clazz = instance.getClass();
        System.err.println(clazz);
//        Method[] methods = clazz.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

        byte[] classFile = generateProxyClass("$proxy1", new Class[]{IHi.class});
        FileOutputStream fos = new FileOutputStream("C://A.class");
        fos.write(classFile);
        fos.flush();
        fos.close();
    }
}
