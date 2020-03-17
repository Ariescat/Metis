package com.metis.io.unicode;

/**
 * @author Ariescat
 * @version 2020/3/17 9:55
 */
public class Test {

    public static void main(String[] args) {

        char[] c = new char[]{'一'};
        System.err.println(Integer.toHexString(c[0]));
        String s = new String(c);
        // String#length事实上调用了char[].length
        System.err.println(s + " " + s.length());

        String str = "一";
        System.err.println(str + " " + str.length());

        // Unicode编码 汉字扩展B '𠀀' 字
        c = new char[]{'\uD840', '\uDC00'};
        s = new String(c);
        System.err.println(s + " " + s.length());

        str = "\uD840\uDC00";
        System.err.println(str + " " + str.length());

        // 输出：由输出可见这个字用了两个char来存
        // 一 1
        // 一 1
        // 𠀀 2
        // 𠀀 2
    }
}
