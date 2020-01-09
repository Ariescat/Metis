package jdk.hotswap;

public class Person {

//    private int i = 3;
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println("hello world!!~~");
//        System.out.println("233456");
//        System.err.println(i);
    }
}
