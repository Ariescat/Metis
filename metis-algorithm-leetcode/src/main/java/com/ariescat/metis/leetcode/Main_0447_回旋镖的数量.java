package com.ariescat.metis.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/number-of-boomerangs/
 * <p>
 * 回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * @date 2021-09-13, 周一
 */
public class Main_0447_回旋镖的数量 {

    public static void main(String[] args) {
        System.err.println(Main_0447_回旋镖的数量.numberOfBoomerangs2(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
        System.err.println(Main_0447_回旋镖的数量.numberOfBoomerangs2(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.err.println(Main_0447_回旋镖的数量.numberOfBoomerangs2(new int[][]{{1, 1}}));
    }

    // 暴力
    public static int numberOfBoomerangs(int[][] points) {
        // System.err.println();
        int ans = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    if (vector_distance(points[i], points[j]) == vector_distance(points[i], points[k])) {
                        // System.err.println(Arrays.toString(points[i]) + ", " + Arrays.toString(points[j]) + ", " + Arrays.toString(points[k]));
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    // 遍历 + 哈希 + 排列组合
    public static int numberOfBoomerangs2(int[][] points) {
        int ans = 0;
        for (int[] point : points) {
            Map<Integer, Integer> dis2Num = new HashMap<>();
            for (int[] point2 : points) {
                int dis = vector_distance(point, point2);
                dis2Num.put(dis, dis2Num.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : dis2Num.entrySet()) {
                Integer dis = entry.getKey();
                Integer num = entry.getValue();
                if (dis > 0 && num > 1) {
                    ans += num * (num - 1); // num里挑2个 排列组合
                }
            }
        }
        return ans;
    }


    public static int vector_distance(int[] points1, int[] points2) {
        return (points1[0] - points2[0]) * (points1[0] - points2[0]) + (points1[1] - points2[1]) * (points1[1] - points2[1]);
    }
}
