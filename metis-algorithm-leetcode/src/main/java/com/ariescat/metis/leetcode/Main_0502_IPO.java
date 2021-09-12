package com.ariescat.metis.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/ipo/
 *
 * @date 2021-09-08, 周三
 */
public class Main_0502_IPO {

    public static void main(String[] args) {
        System.err.println(Main_0502_IPO.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
//        System.err.println(Main_0502_IPO.findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }
        Arrays.sort(projects, Comparator.comparingInt(o -> o.capital));
        int curIndex = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < k; i++) {
            while (curIndex < n && projects[curIndex].capital <= w) {
                queue.add(projects[curIndex].profits);
                curIndex++;
            }
            if (!queue.isEmpty()) {
                w += queue.poll();
            } else {
                break;
            }
        }
        return w;
    }

    static class Project {
        private final int profits;
        private final int capital;

        public Project(int profits, int capital) {
            this.profits = profits;
            this.capital = capital;
        }
    }
}
