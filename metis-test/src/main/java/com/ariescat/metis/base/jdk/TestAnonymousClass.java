package com.ariescat.metis.base.jdk;

public class TestAnonymousClass {

    public static void main(String[] args) {
        A a = new A() {
            @Override
            void eat() {
                System.err.println("eat");
            }
        };
        System.err.println(a.getClass().isAnonymousClass());

        System.err.println(B.class.isAnnotation());
    }

    @B
    static abstract class A {
        abstract void eat();
    }

    @interface B {

    }
}


