package com.ariescat.metis.leetcode;

import java.util.Arrays;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 *
 * <pre>
 * - 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * - 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * </pre>
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class Main_0541_反转字符串_II {

    public static void main(String[] args) {
        Main_0541_反转字符串_II main = new Main_0541_反转字符串_II();
        System.err.println(main.reverseStr("abcdefg", 2));
        System.err.println(main.reverseStr("abcd", 2));
        System.err.println(main.reverseStr("a", 2));
    }

    public String reverseStr(String s, int k) {
        return reverseStr1(s, k);
    }

    // --------------------------------------------------------------------
    public String reverseStr1(String s, int k) {
        if (s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i = i + k * 2) {
            reverseChars1(chars, i, k);
        }
        return new String(chars);
    }

    public void reverseChars(char[] chars, int start, int k) {
        int end = Math.min(start + k, chars.length);
        char[] copy = Arrays.copyOfRange(chars, start, end);
        int index = copy.length - 1;
        for (int i = start; i < end; i++) {
            chars[i] = copy[index--];
        }
    }

    public void reverseChars1(char[] chars, int start, int k) {
        int end = Math.min(start + k, chars.length) - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
