package com.ariescat.metis.leetcode;

import java.util.Arrays;

public class Main_1310_子数组异或查询 {

    public static void main(String[] args) {
//        int[] arr = {1, 3, 4, 8};
//        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        int[] arr = {4, 8, 2, 10};
        int[][] queries = {{2, 3}, {1, 3}, {0, 0}, {0, 3}};

        Main_1310_子数组异或查询 test = new Main_1310_子数组异或查询();
        int[] ret = test.xorQueries(arr, queries);
        System.err.println(Arrays.toString(ret));
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int xor = 0;
            int[] query = queries[i];
            for (int j = query[0]; j <= query[1]; j++) {
                xor = xor ^ arr[j];
            }
            ret[i] = xor;
        }
        return ret;
    }
}
