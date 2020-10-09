package com.ariescat.metis.algorithm.动态规划.最长递增子序列;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ariescat
 * @version 2020/3/26 11:48
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList(2, 1, 4, 3, 1, 5, 6);
        int[] ret = forward(list);

        for (int value : ret) {
            System.err.print(value + " ");
        }
        System.err.println();
    }

    /**
     * See https://blog.csdn.net/mc695192383/article/details/70146579
     */
    private static int[] forward(List<Integer> list) {
        int[] dp = new int[list.size()];
        dp[0] = 1;
        //max标记前面j个数中最大的子序列的长度
        int max = 0;
        for (int i = 1; i < list.size(); i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if (list.get(i) > list.get(j)) {
                    max = Math.max(max, dp[j] + 1);
                } else {
                    max = Math.max(max, 1);
                }
            }
            dp[i] = max;
        }
        System.err.println(max);
        return dp;
    }
}
