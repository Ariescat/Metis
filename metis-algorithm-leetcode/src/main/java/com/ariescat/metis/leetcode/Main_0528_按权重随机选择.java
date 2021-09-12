package com.ariescat.metis.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @date 2021-08-30, 周一
 */
public class Main_0528_按权重随机选择 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Solution2 solution = new Solution2(new int[]{1, 3});
        for (int i = 0; i < 1000000; i++) {
            map.compute(solution.pickIndex(), (key, oldValue) -> {
                if (oldValue == null) {
                    return 1;
                }
                return oldValue + 1;
            });
        }
        System.err.println(map);
    }

    static class Solution {
        int[] w;
        int total;

        public Solution(int[] w) {
            this.w = w;
            for (int j : w) {
                this.total += j;
            }
        }

        public int pickIndex() {
            if (w.length == 1) {
                return 0;
            }
            int random = ThreadLocalRandom.current().nextInt(total);
            int sum = 0;
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                if (sum > random) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class Solution2 {
        int[] w2;

        public Solution2(int[] w) {
            this.w2 = new int[w.length];
            this.w2[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                this.w2[i] = this.w2[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            if (w2.length == 1) {
                return 0;
            }
            int random = ThreadLocalRandom.current().nextInt(w2[w2.length - 1]);
            return binarySearch(random);
        }

        private int binarySearch(int random) {
            int start = 0, end = w2.length - 1;
            while (start < end) {
                int mid = (end - start) / 2 + start;
                if (random >= w2[mid]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            return start;
        }
    }

}
