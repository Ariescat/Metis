package script.groovy.withJava;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.codehaus.groovy.control.CompilerConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GroovyClassLoaderApp {

    /**
     * <p>
     * ָ�����Ŀ¼
     * JVM args: -Dgroovy.target.directory=D:\GitHubProjects\Metis\base-test\src\main\java\script\groovy\withJava\target
     * <p>
     * ��������������ļ������˲�����Ϣ
     * �� Arthas �� jad ������ܺܺõ�չ�ֳ���
     */
    public static void main(String[] args) throws InterruptedException {
//        loadClass();
//        System.out.println("======================");
//        loadFile();
        loadInterfaceFile();

        // ���� arthas ���
        while (true) {
            Thread.sleep(2000L);
            System.err.println("arthas...");
        }
    }

    /**
     * ͨ�������groovy
     */
    private static void loadClass() {
        GroovyObject groovyObject = null;
        try {
            /**
             * ���� java.lang.ClassCastException: script.groovy.withJava.TestGroovy cannot be cast to groovy.lang.GroovyObject
             *
             * �²� ClassLoader ����
             */
            groovyObject = (GroovyObject) GroovyClassLoaderApp.class.getClassLoader().loadClass("script.groovy.withJava.TestGroovy").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // ִ���޲κ���
        groovyObject.invokeMethod("print", null);

        System.out.println("============================");

        // ִ���вκ���
        Object[] objects = new Object[]{"abc", "def", "ghi"};
        @SuppressWarnings("unchecked")
        List<String> ls = (List<String>) groovyObject.invokeMethod("printArgs", objects);
        ls.forEach(System.out::println);
    }


    private static Object getGroovyObject(String path) throws IOException, InstantiationException, IllegalAccessException {
        CompilerConfiguration config = new CompilerConfiguration();
        config.setSourceEncoding("UTF-8");
        // ���ø�GroovyClassLoader�ĸ�ClassLoaderΪ��ǰ�̵߳ļ�����(Ĭ��)
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader(), config);

        // ���TestGroovy���غ��class
        File groovyFile = new File(path);
        Class<?> groovyClass = groovyClassLoader.parseClass(groovyFile);
        // ���TestGroovy��ʵ��
        return groovyClass.newInstance();
    }

    /**
     * ͨ���ļ�·������groovy
     *
     * @return
     */
    private static void loadFile() {
        try {
            GroovyObject groovyObject = (GroovyObject) getGroovyObject("D:\\GitHubProjects\\Metis\\base-test\\src\\main\\java\\script\\groovy\\withJava\\TestGroovy.java");

            // �������printArgs�����õ�����ֵ
            /**
             * {@link org.codehaus.groovy.reflection.CachedClass#methods } ���ﻺ�������е� Method
             * �ϵ��� {@link groovy.lang.MetaClassImpl#initialize()#fillMethodIndex() } �����ڴ˹���Method������addInterfaceMethods, populateMethods
             * ����ֻ�Ƿ��������JDK��Method
             */
            @SuppressWarnings("unchecked")
            List<String> result = (List<String>) groovyObject.invokeMethod("printArgs", new Object[]{"chy", "zjj", "xxx"});
            result.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void loadInterfaceFile() {
        try {
            Object object = getGroovyObject("D:\\GitHubProjects\\Metis\\base-test\\src\\main\\java\\script\\groovy\\withJava\\TestGroovy2.java");

            /**
             * java.lang.ClassCastException: script.groovy.withJava.TestGroovy2 cannot be cast to script.groovy.withJava.TestGroovy2
             */
//            TestGroovy2 groovyObject = (TestGroovy2) object;

            /**
             * �ϵ��� {@link script.groovy.withJava.TestGroovy2#print(java.lang.String) } �������ر�
             * �������ڴ��׳�һ���쳣���鿴����������ִ�й��̣��ᷢ�ַ������������������õĵ��� ���ǻ��� Callsite �ĵ��ã�callConstructor, callCurrent
             *
             * ep��
             * java.lang.RuntimeException: pppp
             * 	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
             * 	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
             * 	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
             * 	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
             * 	at org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:80)
             * 	at org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrapNoCoerce.callConstructor(ConstructorSite.java:105)
             * 	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:59)
             * 	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:237)
             * 	at org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:249)
             */
            ITestGroovy2 groovyObject = (ITestGroovy2) object;
            groovyObject.print("hello word!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
