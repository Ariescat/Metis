package com.ariescat.metis.leetcode;

/**
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 *
 * @date 2021-09-07, 周二
 */
public class Main_1221_分割平衡字符串 {

    public static void main(String[] args) {
        System.err.println(Main_1221_分割平衡字符串.balancedStringSplit("RLRRLLRLRL"));
        System.err.println(Main_1221_分割平衡字符串.balancedStringSplit("RLLLLRRRLR"));
        System.err.println(Main_1221_分割平衡字符串.balancedStringSplit("LLLLRRRR"));
        System.err.println(Main_1221_分割平衡字符串.balancedStringSplit("RLRRRLLRLL"));
    }

    public static int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int numR = 0, numL = 0, ret = 0;
        for (char c : chars) {
            if (c == 'R') {
                numR++;
            } else {
                numL++;
            }
            if (numR == numL) {
                ret++;
                numR = 0;
                numL = 0;
            }
        }
        return ret;
    }
}
