package com.ariescat.metis.java.base.string;

public class TestIntern {

    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
//        s = s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
//        s3 = s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
