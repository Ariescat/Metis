package com.ariescat.metis.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/text-justification/
 *
 * @date 2021-09-09, 周四
 */
public class Main_0068_文本左右对齐 {

    public static void main(String[] args) {
        Main_0068_文本左右对齐.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16)
                .forEach(str -> System.err.println(str + "  " + str.length()));
        System.err.println();
        Main_0068_文本左右对齐.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16)
                .forEach(str -> System.err.println(str + "  " + str.length()));
        System.err.println();
        Main_0068_文本左右对齐.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20)
                .forEach(str -> System.err.println(str + "  " + str.length()));
        System.err.println();
        Main_0068_文本左右对齐.fullJustify(new String[]{"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"}, 16)
                .forEach(str -> System.err.println(str + "  " + str.length()));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int curLength = 0;
        List<String> retList = new ArrayList<>();
        List<String> curList = new ArrayList<>(4);

        for (String word : words) {
            if ((curLength += word.length()) > maxWidth) {
                retList.add(gen(curList, maxWidth, false));

                curLength = word.length();
                curList.clear();
            }
            curLength++; // 应至少有一个空格
            curList.add(word);
        }
        if (!curList.isEmpty()) {
            retList.add(gen(curList, maxWidth, true));
        }
        return retList;
    }

    private static String gen(List<String> curList, int maxWidth, boolean isLast) {
//        int curL = curList.stream().mapToInt(String::length).sum();
        int curL = 0;
        for (String s : curList) {
            curL += s.length();
        }

        int left = maxWidth - curL; // 需要填充的空格
        int[] space = new int[curList.size()];
        if (curList.size() == 1) {
            space[0] = left;
        } else if (isLast) {
            Arrays.fill(space, 1);
            int last = maxWidth - curL - space.length;
            space[space.length - 1] = last + 1;
        } else {
            // avgSpaces
            Arrays.fill(space, left / (curList.size() - 1));
            space[curList.size() - 1] = 0; // 最后一个不需要
            int extraSpaces = left % (curList.size() - 1); // 均摊
            for (int i = 0; i < extraSpaces; i++) {
                space[i]++;
            }
        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < curList.size(); i++) {
            builder.append(curList.get(i));
            for (int j = 0; j < space[i]; j++) {
                builder.append(' ');
            }
        }
        return builder.toString();
    }
}
