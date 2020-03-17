package com.metis.groovy.withJava;

import base.math.round.Main;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * groovy版本：2.5.7
 */
public class GroovyClassLoaderApp {

    /**
     * <p>
     * 指定输出目录
     * JVM args: -Dgroovy.target.directory=D:\GitHubProjects\Metis\base-test\src\main\java\script\groovy\withJava\target
     * <p>
     * 但反编译出来的文件隐藏了部分信息
     * 用 Arthas 的 jad 命令就能很好的展现出来
     */
    public static void main(String[] args) throws InterruptedException {
//        loadClass();
//        System.out.println("======================");
//        loadFile();
        loadInterfaceFile();

        // 便于 arthas 监控
        while (true) {
            Thread.sleep(2000L);
            System.err.println("arthas...");
        }
    }

    /**
     * 通过类加载groovy
     */
    private static void loadClass() {
        GroovyObject groovyObject = null;
        try {
            /**
             * 会抛 java.lang.ClassCastException: com.metis.groovy.withJava.TestGroovy cannot be cast to groovy.lang.GroovyObject
             *
             * 猜测 ClassLoader 导致
             */
            groovyObject = (GroovyObject) GroovyClassLoaderApp.class.getClassLoader().loadClass("com.metis.groovy.withJava.TestGroovy").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 执行无参函数
        groovyObject.invokeMethod("print", null);

        System.out.println("============================");

        // 执行有参函数
        Object[] objects = new Object[]{"abc", "def", "ghi"};
        @SuppressWarnings("unchecked")
        List<String> ls = (List<String>) groovyObject.invokeMethod("printArgs", objects);
        ls.forEach(System.out::println);
    }


    private static Object getGroovyObject(String path) throws IOException, InstantiationException, IllegalAccessException {
        String userDir = System.getProperty("user.dir");

        CompilerConfiguration config = new CompilerConfiguration();
        config.setSourceEncoding("UTF-8");
        config.setTargetDirectory(userDir + "\\base-test\\src\\main\\java\\script\\groovy\\withJava\\target");
        // 设置该GroovyClassLoader的父ClassLoader为当前线程的加载器(默认)
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader(), config);

        // 获得TestGroovy加载后的class
        File groovyFile = new File(userDir + path);
        Class<?> groovyClass = groovyClassLoader.parseClass(groovyFile);
        // 获得TestGroovy的实例
        return groovyClass.newInstance();
    }

    /**
     * 通过文件路径加载groovy
     *
     * @return
     */
    private static void loadFile() {
        try {
            GroovyObject groovyObject = (GroovyObject) getGroovyObject("\\base-test\\src\\main\\java\\script\\groovy\\withJava\\TestGroovy.java");

            // 反射调用printArgs方法得到返回值
            /**
             * {@link org.codehaus.groovy.reflection.CachedClass#methods } 这里缓存了所有的 Method
             * 断点于 {@link groovy.lang.MetaClassImpl#initialize()#fillMethodIndex() } 发现在此构建Method索引：addInterfaceMethods, populateMethods
             * 最终只是反射调用了JDK的Method
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
            Object object = getGroovyObject("\\base-test\\src\\main\\java\\script\\groovy\\withJava\\TestGroovy2.java");

            /**
             * java.lang.ClassCastException: com.metis.groovy.withJava.TestGroovy2 cannot be cast to com.metis.groovy.withJava.TestGroovy2
             */
//            TestGroovy2 groovyObject = (TestGroovy2) object;

            /**
             * 断点于 {@link com.metis.groovy.withJava.TestGroovy2#print(java.lang.String) } 看不出特别
             * 但可以在此抛出一个异常来查看方法体里面执行过程，会发现方法里面若有其他引用的调用 都是基于 Callsite 的调用：callConstructor, callCurrent
             * ep：
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
             *
             *
             * 方法内部调用可能有优化:
             *         if (!__$stMC && !BytecodeInterface8.disabledStandardMetaClass()) {
             *             this.testCall();
             *             Object var10000 = null;
             *         } else {
             *             var2[2].callCurrent(this);
             *         }
             *
             * 断点于 {@link Main#main(java.lang.String[])}, 发现调用外部类还是JDK Method反射调用
             *   at base.math.round.Main.main(Main.java:10)
             *   at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
             *   at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
             *   at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
             *   at java.lang.reflect.Method.invoke(Method.java:498)
             *   at org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:101)
             *   at groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:323)
             *   at org.codehaus.groovy.runtime.callsite.StaticMetaMethodSite.invoke(StaticMetaMethodSite.java:44)
             *   at org.codehaus.groovy.runtime.callsite.StaticMetaMethodSite.call(StaticMetaMethodSite.java:89)
             *   at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)
             *   at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:115)
             *   at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:127)
             *   at com.metis.groovy.withJava.TestGroovy2.print(TestGroovy2.java:15)
             *
             *
             * 百度 groovy CallSite，可以看到，虽然提供了很高的灵活性(动态调用)，但是也牺牲了一部分性能
             * 但 groovy dgm 为大部分的热点代码(几百上千个热点) 做了直接调用的优化 {@link PogoMetaMethodSite#invoke}
             *
             *
             * 附 online exception 这里有一个配置实体为null，看底层的null处理 (2.1.3 版本)：
             *  java.lang.NullPointerException: Cannot invoke method getKillMonsterValue() on null object
             *  	at org.codehaus.groovy.runtime.NullObject.invokeMethod(NullObject.java:77)
             *  	at org.codehaus.groovy.runtime.callsite.PogoMetaClassSite.call(PogoMetaClassSite.java:45)
             *  	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:45)
             *  	at org.codehaus.groovy.runtime.callsite.NullCallSite.call(NullCallSite.java:32)
             *  	at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:45)
             *  	at com.mmorpg.logic.mindmagic.config.ConfigMindMagicModel$getKillMonsterValue.call(Unknown Source)
             *  	at com.mmorpg.logic.mindmagic.MindMagicService.onOneKillMonster(MindMagicService:260)
             */
            ITestGroovy2 groovyObject = (ITestGroovy2) object;
            groovyObject.print("hello word!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
