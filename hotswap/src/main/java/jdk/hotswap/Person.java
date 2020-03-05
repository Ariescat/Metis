package jdk.hotswap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Person {

    //    private int i = 3;
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void list() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(4);
        list.add(7);
        Collections.sort(list);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.err.println(list);
    }

    public void sayHello() {
        System.out.println("hello world!!~~");
//        System.out.println("233456");
//        System.err.println(i);
    }
}
