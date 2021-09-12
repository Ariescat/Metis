package com.ariescat.metis.leetcode;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 *
 * @date 2021-09-01, 周三
 */
public class Main_面试题_17_14_最小K个数 {

    public static void main(String[] args) {
        Main_面试题_17_14_最小K个数 main = new Main_面试题_17_14_最小K个数();
        System.err.println(Arrays.toString(main.smallestK2(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }

    public int[] smallestK(int[] arr, int k) {
        if (arr.length <= k) {
            return arr;
        }
        qSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    private void qSort(int[] arr, int left, int right, int k) {
        if (left > right)
            return;
        int partition = partition(arr, left, right);

        if (k - 1 == partition) {
            return;
        } else if (k - 1 < partition) {
            qSort(arr, left, partition - 1, k);
        } else {
            qSort(arr, partition + 1, right, k);
        }
    }

    private int partition(int[] arr, int low, int high) {
//        int random = ThreadLocalRandom.current().nextInt(low, high + 1);
//        swap arr[low] arr[random]
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    // ------------------------------------------------------------------------

    public int[] smallestK2(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);
        int[] vec = new int[k];
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition2(nums, l, r);
    }

    private int partition2(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
