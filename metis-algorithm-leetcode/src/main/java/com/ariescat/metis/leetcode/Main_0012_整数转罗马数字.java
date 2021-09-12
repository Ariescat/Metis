package com.ariescat.metis.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Main_0012_整数转罗马数字 {

    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public String intToRoman(int num) {
        // TODO
        return "";
    }

    public static void main(String[] args) {
        Main_0012_整数转罗马数字 test = new Main_0012_整数转罗马数字();
        System.err.println(test.intToRoman(3));
        System.err.println(test.intToRoman(4));
        System.err.println(test.intToRoman(9));
        System.err.println(test.intToRoman(58));
    }

}
