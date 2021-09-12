package com.ariescat.metis.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-cost-to-reach-destination-in-time/
 */
public class Main_1928_规定时间内到达终点的最小花费 {

    public static void main(String[] args) {
        Main_1928_规定时间内到达终点的最小花费 main = new Main_1928_规定时间内到达终点的最小花费();
        System.err.println(main.minCost(30,
                new int[][]{{0, 1, 10}, {1, 2, 10}, {2, 5, 10}, {0, 3, 1}, {3, 4, 10}, {4, 5, 15}},
                new int[]{5, 1, 2, 20, 20, 3}));
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int INF = Integer.MAX_VALUE - 1000;
        int citySize = passingFees.length;
        //  dpFee[t][i] 表示使用恰好 t 分钟到达城市 i 需要的最少通行费总和。
        int[][] dpFee = new int[maxTime + 1][citySize];
        for (int[] fee : dpFee) {
            Arrays.fill(fee, INF);
        }
        dpFee[0][0] = passingFees[0];

        for (int t = 1; t <= maxTime; t++) {
            for (int[] edge : edges) {
                int from = edge[0], to = edge[1], cost = edge[2];
                if (t >= cost) {
//                    try {
                        dpFee[t][from] = Math.min(dpFee[t][from], dpFee[t - cost][to] + passingFees[from]);
                        dpFee[t][to] = Math.min(dpFee[t][to], dpFee[t - cost][from] + passingFees[to]);
//                    } catch (Exception e) {
//                        System.err.println("t: " + t + ", edge: " + Arrays.toString(edge));
//                        e.printStackTrace();
//                    }
                }
            }
        }

        int retCost = INF;
        for (int t = 1; t <= maxTime; t++) {
            retCost = Math.min(retCost, dpFee[t][citySize - 1]);
        }

        return retCost >= INF ? -1 : retCost;
    }
}
