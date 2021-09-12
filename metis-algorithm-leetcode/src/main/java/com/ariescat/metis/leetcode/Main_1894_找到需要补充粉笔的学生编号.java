package com.ariescat.metis.leetcode;

/**
 * https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/
 *
 * @date 2021-09-10, 周五
 */
public class Main_1894_找到需要补充粉笔的学生编号 {

    public static void main(String[] args) {
        System.err.println(Main_1894_找到需要补充粉笔的学生编号.chalkReplacer2(new int[]{5, 1, 5}, 22));
        System.err.println(Main_1894_找到需要补充粉笔的学生编号.chalkReplacer2(new int[]{3, 4, 1, 2}, 25));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        long consume = 0;
        for (int c : chalk) {
            consume += c;
        }
        long left = k % consume;
        for (int i = 0; i < chalk.length; i++) {
            if (left < chalk[i]) {
                return i;
            } else {
                left -= chalk[i];
            }
        }
        return 0;
    }

    // ---------------------------------------------------------------

    public static int chalkReplacer2(int[] chalk, int k) {
        if (chalk[0] > k) {
            return 0;
        }
        for (int i = 1; i < chalk.length; i++) {
            chalk[i] += chalk[i - 1];
            if (chalk[i] > k) {
                return i;
            }
        }
        k %= chalk[chalk.length - 1];
        return binarySearch(chalk, k);
    }

    private static int binarySearch(int[] chalk, int target) {
        int left = 0, right = chalk.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (chalk[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
