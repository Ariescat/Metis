package com.ariescat.metis.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * https://leetcode-cn.com/problems/get-maximum-in-generated-array/
 */
public class Main_1646_获取生成数组中的最大值 {

    public static void main(String[] args) {
        Main_1646_获取生成数组中的最大值 main = new Main_1646_获取生成数组中的最大值();
//        System.err.println(main.getMaximumGenerated(0) == main.getMaximumGenerated2(0));
//        System.err.println(main.getMaximumGenerated(1) == main.getMaximumGenerated2(1));
        System.err.println(main.getMaximumGenerated(2) == main.getMaximumGenerated2(2));
//        System.err.println(main.getMaximumGenerated(3) == main.getMaximumGenerated2(3));
//        System.err.println(main.getMaximumGenerated(7) == main.getMaximumGenerated2(7));
    }

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;

        int max = 0;
        for (int k = 2; k < nums.length; k++) {
            int i;
            if ((k & 0x01) == 0) {
                // 偶数
                i = k / 2;
                nums[k] = nums[i];
            } else {
                i = (k - 1) / 2;
                nums[k] = nums[i] + nums[i + 1];
            }
            max = Math.max(nums[k], max);
        }
        return max;
    }

    public int getMaximumGenerated2(int n) {
        if (n < 2) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;

        n += n & 1;
        int half = n >> 1;
//        int max = 0;
        for (int i = 1; i < half; i++) {
            nums[i * 2] = nums[i];
//            max = Math.max(nums[i * 2], max);
            nums[i * 2 + 1] = nums[i] + nums[i + 1];
//            max = Math.max(nums[i * 2 + 1], max);
        }
        // 这里必须整个数组取最大，用上面的max比较，当n为2时，会比较不到
        return Arrays.stream(nums).max().getAsInt();
    }
}
