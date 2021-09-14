package com.ariescat.metis.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 *
 * @date 2021-09-14, 周二
 */
public class Main_0524_通过删除字母匹配到字典里最长单词 {

    public static void main(String[] args) {
        System.err.println(Main_0524_通过删除字母匹配到字典里最长单词.findLongestWord3("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        System.err.println(Main_0524_通过删除字母匹配到字典里最长单词.findLongestWord3("abpcplea", Arrays.asList("a", "b", "c")));
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String dic : dictionary) {
            if (isMatch(s, dic)) {
                if (dic.length() > ans.length()
                        || (dic.length() == ans.length() && dic.compareTo(ans) < 0)) {
                    ans = dic;
                }
            }
        }
        return ans;
    }

    // 先排序 长度降序和字典序升序
    public static String findLongestWord2(String s, List<String> dictionary) {
        String ans = "";
        dictionary.sort((word1, word2) -> {
            if (word1.length() != word2.length()) {
                return word2.length() - word1.length();
            } else {
                return word1.compareTo(word2);
            }
        });
        for (String dic : dictionary) {
            if (isMatch(s, dic)) {
                return dic;
            }
        }
        return ans;
    }

    private static boolean isMatch(String src, String target) {
        int i = 0, j = 0;
        while (i < target.length() && j < src.length()) {
            if (target.charAt(i) == src.charAt(j)) {
                ++i;
            }
            ++j;
        }
        return i == target.length();
//        下面这种的效率太慢了！！
//        int srcLength = src.length(), srcIndex = 0;
//        for (int i = 0; i < target.toCharArray().length; i++) {
//            char c = target.charAt(i);
//            while (srcIndex < srcLength && src.charAt(srcIndex) != c) {
//                srcIndex++;
//            }
//            srcIndex++; // 相等加1 下一位比较
//        }
//        return srcIndex <= srcLength;
    }

    public static String findLongestWord3(String s, List<String> dictionary) {
        int m = s.length();
        // f[i][j] 表示字符串 s 中从位置 i 开始往后字符 j 第一次出现的位置
        int[][] f = new int[m + 1][26];
        Arrays.fill(f[m], m);

        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < 26; ++j) {
                if (s.charAt(i) == (char) ('a' + j)) {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        String res = "";
        for (String t : dictionary) {
            boolean match = true;
            int j = 0;
            for (int i = 0; i < t.length(); ++i) {
                if (f[j][t.charAt(i) - 'a'] == m) {
                    match = false;
                    break;
                }
                j = f[j][t.charAt(i) - 'a'] + 1;
            }
            if (match) {
                if (t.length() > res.length() ||  (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }
}
