package com.metis.base.jdk8.colon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Main {

    /**
     * 这里的测试是: 为什么compareTo也能通过
     * List<Integer> list = new ArrayList<>();
     * list.sort(Integer::compare);
     * list.sort(Integer::compareTo);
     */
    public static void main(String[] args) {
        funtion1(new Fun1() {
            @Override
            public int fun(Entity o1, Entity o2) {
                return o1.testInt(o2);
            }
        });
        funtion1((o1, o2) -> o1.testInt(o2));
        funtion1(Entity::testInt); // 静态
        funtion1(Entity::test); // 实例

        funtion1(TestFun::a1); //  funtion1(Entity::testInt);
//        funtion1(TestFun::a2); // 编译不通过
//        funtion1(TestFun::a3); // 编译不通过
        funtion1(new TestFun("entity")::a3);


        funtion2(TestFun::b1);
//        funtion2(TestFun::b2); // 编译不通过
//        funtion2(TestFun::b3); // 注意！编译不通过
        funtion2(new TestFun("entity")::b3);


        funtion3(TestFun::c1);
//        funtion3(TestFun::c2); // 编译不通过
        funtion3(new TestFun("entity")::c2);


        funtion4(TestFun::d1);
//        funtion4(TestFun::d2); // 编译不通过
        funtion4(new TestFun("entity")::d2);

        /**
         * 因此，猜测 若接口的参数类型一样 可直接用::调用实例方法
         */

        // --------------------------------------------------

        /**
         * 后面补充：其实上面猜测是片面的，::是lambda表达式的方法引用，不能脱离lambda的传参来盲目猜测
         */
        List<Integer> list = new ArrayList<>();
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
                return Integer.compare(o1, o2);
            }
        });
        list.sort(Integer::compare);
        list.sort(Integer::compareTo);

        list.stream().map(new Function<Integer, Byte>() {
            @Override
            public Byte apply(Integer i) {
                return i.byteValue();
            }
        });
        list.stream().map(Integer::byteValue);

        List<TestFun> list2 = new ArrayList<>();
        list2.stream().map(new Function<TestFun, String>() {
            @Override
            public String apply(TestFun test) {
                return test.getDesc();
            }
        });
        list2.stream().map(TestFun::getDesc); // 看，是不是都一样的，也可以理解成是第一个参数的调用

        IntStream.of(new int[]{1, 2, 3}).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
        IntStream.of(new int[]{1, 2, 3}).forEach(value -> System.out.println(value));
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println); // 这里又可以理解成传参
        IntStream.of(new int[]{1, 2, 3}).forEach(TestFun::c1);

        /**
         * 若是调用lambda参数本身，可直接用参数类型::实例方法
         * 若lambda参数只是传递作用，则匹配参数类型的静态或实例方法
         */
    }

    static void funtion1(Fun1 f) {
    }

    static void funtion2(Fun2 f2) {
    }

    static void funtion3(Fun3 f2) {
    }

    static void funtion4(Fun4 f2) {
    }

    // ---------------------------------------------------------------------------
    // ---------------------------------------------------------------------------
    // ---------------------------------------------------------------------------

    static class TestFun {

        private String desc;

        TestFun(String desc) {
            this.desc = desc;
        }

        String getDesc() {
            return desc;
        }

        static int a1(Entity o1, Entity o2) {
            return 1;
        }

        int a2(Entity o) {
            return 2;
        }

        int a3(Entity o1, Entity o2) {
            return 3;
        }

        // ---------------------- Fun2 ----------------------
        static int b1(int o1, Entity o2) {
            return 1;
        }

        int b2(Entity o) {
            return 2;
        }

        int b3(int o1, Entity o2) {
            return 3;
        }

        // ---------------------- Fun3 ----------------------
        static int c1(int o1) {
            return 1;
        }

        int c2(int o) {
            return 2;
        }

        // ---------------------- Fun4 ----------------------
        static int d1() {
            return 1;
        }

        int d2() {
            return 2;
        }
    }

    // ---------------------------------------------------------------------------
    // ---------------------------------------------------------------------------
    // ---------------------------------------------------------------------------

    static class Entity {
        static int test(Entity e, Entity e2) {
            return 3;
        }

        int testInt(Entity e) {
            return 2;
        }
    }

    // ---------------------------------------------------------------------------
    // ---------------------------------------------------------------------------
    // ---------------------------------------------------------------------------

    interface Fun1 {
        /**
         * param1与param2 类型一样
         */
        int fun(Entity o1, Entity o2);
    }

    interface Fun2 {
        /**
         * param1与param2 类型 不一样
         */
        int fun(int o1, Entity o2);
    }

    interface Fun3 {
        /**
         * 只有一个参数
         */
        int fun(int o1);
    }

    interface Fun4 {
        /**
         * 无参
         */
        int fun();
    }
}
