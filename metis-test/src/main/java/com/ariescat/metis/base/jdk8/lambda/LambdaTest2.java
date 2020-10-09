package com.ariescat.metis.base.jdk8.lambda;

import java.util.function.Consumer;

/**
 * Java中的lambda每次执行都会创建一个新对象吗
 * <p>
 * See https://cloud.tencent.com/developer/article/1572212
 *
 * @author Ariescat
 * @version 2020/4/14 13:03
 */
public class LambdaTest2 {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            test1(i);
        }
        for (int i = 0; i < 3; i++) {
            test2(i);
        }
        for (int i = 0; i < 3; i++) {
            test3(i);
        }
        for (int i = 0; i < 3; i++) {
            test4(i);
        }
    }

    static void test1(int a) {
        /*
         * 如果lambda表达式里使用了上下文中的其他变量，则每次lambda表达式的执行，都会创建一个新对象
         */
        forEach(b -> check(a + b));
    }

    static void test2(int a) {
        /*
         * 当lambda表达式里没有使用上下文中的其他变量时，则每次执行lambda表达式都使用同一个对象
         */
        forEach(LambdaTest2::check); // 等同于forEach(b -> check(b))
    }

    static void test3(int a) {
        /*
         * 每次创建一个新对象
         */
        forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                check(a + i);
            }
        });
    }

    static void test4(int a) {
        /*
         * 每次创建一个新对象
         */
        forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                check(integer);
            }
        });
    }

    static void forEach(Consumer<Integer> c) {
        System.out.println(c + " \t\t" + c.getClass());
        c.accept(1);
    }

    static void check(int i) {
        if (i < 0) {
            throw new RuntimeException();
        }
    }
}
