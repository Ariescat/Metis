package com.ariescat.metis.leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/
 */
public class Main_0787_K站中转内最便宜的航班 {

    public static void main(String[] args) {
        Main_0787_K站中转内最便宜的航班 main = new Main_0787_K站中转内最便宜的航班();
//        System.err.println(main.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
//        System.err.println(main.findCheapestPrice(5, new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}}, 2, 1, 1));
//        System.err.println(main.test(3,
//                new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
//                0, 2, 1));
//        System.err.println(main.test(5,
//                new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}},
//                2, 1, 1));
        System.err.println(main.test(3,
                new int[][]{{0, 1, 2}, {1, 2, 1}, {2, 0, 10}},
                1, 2, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return findCheapestPrice3(n, flights, src, dst, k);
    }

    public boolean test(int n, int[][] flights, int src, int dst, int k) {
        Main_0787_K站中转内最便宜的航班 main = new Main_0787_K站中转内最便宜的航班();
        return main.findCheapestPrice2(n, flights, src, dst, k) == main.findCheapestPrice3(n, flights, src, dst, k);
    }

    @Deprecated
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> startFlights = new HashMap<>();
        Map<Integer, List<int[]>> endFlights = new HashMap<>();
        for (int[] flight : flights) {
            List<int[]> ints = startFlights.computeIfAbsent(flight[0], key -> new ArrayList<>());
            ints.add(flight);
            ints = endFlights.computeIfAbsent(flight[1], key -> new ArrayList<>());
            ints.add(flight);
        }
        List<int[]> startList = startFlights.get(src);
        int[] mins = new int[startList.size()];
        for (int i = 0; i < startList.size(); i++) {
            int[] ints = startList.get(i);
            int cost = ints[2];
            if (mins[i] == 0) {
                mins[i] = cost;
            }
            mins[i] = Math.min(mins[i], cost);
        }
        return -1;
    }

    private int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE - (int) Math.pow(10, 4);
        int[] preDis = new int[n];
        Arrays.fill(preDis, INF);

        preDis[src] = 0;

        int retDis = INF;
        for (int i = 1; i <= k + 1; i++) {
            int[] curDis = new int[n];
            Arrays.fill(curDis, INF);
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], cost = flight[2];
                curDis[to] = Math.min(curDis[to], preDis[from] + cost);
            }
            preDis = curDis;
            retDis = Math.min(retDis, curDis[dst]);
        }

        return retDis >= INF ? -1 : retDis;
    }

    private int findCheapestPrice3(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE - (int) Math.pow(10, 4);
        // k + 1 + k为0
        int[][] dpDis = new int[k + 1 + 1][n];
        for (int[] arr : dpDis) {
            Arrays.fill(arr, INF);
        }
        dpDis[0][src] = 0;

        for (int i = 1; i <= k + 1; i++) {
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], cost = flight[2];
                dpDis[i][to] = Math.min(dpDis[i][to], dpDis[i - 1][from] + cost);
            }
        }

        int retDis = INF;
        for (int i = 0; i < dpDis.length; i++) {
            retDis = Math.min(retDis, dpDis[i][dst]);
        }

        return retDis >= INF ? -1 : retDis;
    }
}
