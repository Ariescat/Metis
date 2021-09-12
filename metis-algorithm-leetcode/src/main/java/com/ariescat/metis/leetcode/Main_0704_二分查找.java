package com.ariescat.metis.leetcode;

/**
 * https://leetcode-cn.com/problems/binary-search/
 *
 * @date 2021-09-06, 周一
 */
public class Main_0704_二分查找 {

    public static void main(String[] args) {
        System.err.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.err.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 13));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
