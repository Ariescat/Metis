package com.ariescat.metis.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Main_0013_罗马数字转整数 {

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

    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer value = symbolValues.get(c);
            if (i < s.length() - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                sum -= value;
            } else {
                sum += value;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Main_0013_罗马数字转整数 test = new Main_0013_罗马数字转整数();
        System.err.println(test.romanToInt("III"));
        System.err.println(test.romanToInt("IV"));
        System.err.println(test.romanToInt("LVIII"));
        System.err.println(test.romanToInt("MCMXCIV"));
    }
}
