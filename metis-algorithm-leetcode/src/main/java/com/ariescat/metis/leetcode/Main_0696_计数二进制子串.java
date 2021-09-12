package com.ariescat.metis.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 *
 *
 * 示例 1 :
 *
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 *
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 *
 *
 * 提示：
 *
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 *
 * https://leetcode-cn.com/problems/count-binary-substrings/
 */
public class Main_0696_计数二进制子串 {

    public static void main(String[] args) {
        Main_0696_计数二进制子串 main = new Main_0696_计数二进制子串();
        System.err.println(main.countBinarySubstrings("00110011"));
        System.err.println(main.countBinarySubstrings("10101"));

        System.err.println(main.countBinarySubstrings2("00110011"));
        System.err.println(main.countBinarySubstrings2("10101"));
    }

    public int countBinarySubstrings(String s) {
        int ptr = 0, length = s.length();
        List<Integer> counts = new ArrayList<>();
        while (ptr < length) {
            char c = s.charAt(ptr);

            int count = 1;
            while (++ptr < length && c == s.charAt(ptr)) {
                count++;
            }
            counts.add(count);
        }

        int num = 0;
        for (int i = 1; i < counts.size(); i++) {
            num += Math.min(counts.get(i), counts.get(i - 1));
        }
        return num;
    }

    public int countBinarySubstrings2(String s) {
        int ptr = 0, length = s.length();
        int last = 0;
        int num = 0;
        while (ptr < length) {
            char c = s.charAt(ptr);

            int count = 1;
            while (++ptr < length && c == s.charAt(ptr)) {
                count++;
            }
            num += Math.min(last, count);
            last = count;
        }
        return num;
    }
}
