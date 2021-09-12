package com.ariescat.metis.leetcode.不太懂;

/**
 * 421. 数组中两个数的最大异或值
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * <p>
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 */
public class Main_0421_数组中两个数的最大异或值 {

    public static void main(String[] args) {
        Main_0421_数组中两个数的最大异或值 test = new Main_0421_数组中两个数的最大异或值();
        int ret = test.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});
        System.err.println(ret);
    }

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                max = Math.max(nums[i] ^ nums[j], max);
            }
        }
        return max;
    }
}
