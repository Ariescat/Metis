package com.metis.base.jdk8.lambda;

import java.lang.invoke.LambdaMetafactory;

/**
 * 查看字节码 lambda的底层实现原理
 *
 * @author Ariescat
 * @version 2019/12/31 15:28
 */
public class LambdaTest {
    public static void printString(String s, Print<String> print) {
        print.print(s);
    }

    /**
     * 断点于 ：
     * {@link LambdaMetafactory#metafactory }
     * {@link java.lang.invoke.ConstantCallSite#dynamicInvoker() }
     *
     * See https://zhuanlan.zhihu.com/p/39215520
     *
     * 总结：动态调用点的 调用的方法 是 java.lang.invoke.LambdaMetafactory.metafactory 帮我们生成的
     *      函数非常简单，只有两行代码，真正创建动态调用点的地方在 mf.buildCallSite 方法中，主要做了三件事：
     *              （1）通过ASM工具生成名为 **.LambdaTest$$Lambda$1 的类的字节码
     *              （2）为 **.LambdaTest$$Lambda$1 类创建实例，并转换为 Print 对应的 MethodHandle
     *              （3）将（2）中的MethodHandler做为target生成动态调用点，并返回
     *      lambda 表达式并不是直接翻译成静态函数，lambda的编译会产生一个bootstrap method，bootstrap method 返回 callsite，callsite 由 jvm 的invokedynamic执行。
     */
    public static void main(String[] args) {
        printString("test", (x) -> System.out.println(x));
    }
}

@FunctionalInterface
interface Print<T> {
    public void print(T x);
}

//public class Lambda {
//    public static void printString(String s, Print<String> print) {
//        print.print(s);
//    }
//    private static void lambda$0(String x) {
//        System.out.println(x);
//    }
//    final class $Lambda$1 implements Print{
//        @Override
//        public void print(Object x) {
//            lambda$0((String)x);
//        }
//    }
//    public static void main(String[] args) {
//        printString("test", new Lambda().new $Lambda$1());
//    }
//}