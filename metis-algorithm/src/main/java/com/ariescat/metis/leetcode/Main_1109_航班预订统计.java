package com.ariescat.metis.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 *
 * @date 2021-08-31, 周二
 */
public class Main_1109_航班预订统计 {


    public static void main(String[] args) {
        Main_1109_航班预订统计 main = new Main_1109_航班预订统计();
        System.err.println(Arrays.toString(main.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
//        System.err.println(Arrays.toString(main.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 2, 15}}, 2)));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        return corpFlightBookings_2_GreyArray(bookings, n);
    }

    public int[] corpFlightBookings_1_force(int[][] bookings, int n) {
        int[] answer = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                answer[i - 1] += booking[2];
            }
        }
        return answer;
    }

    // 差分数组
    public int[] corpFlightBookings_2_GreyArray(int[][] bookings, int n) {
        int[] grayArray = new int[n], answer = new int[n];
        for (int[] booking : bookings) {
            grayArray[booking[0] - 1] += booking[2];
//            if (booking[1] - 1 + 1 < n) {
            if (booking[1] < n) {
                grayArray[booking[1]] -= booking[2];
            }
        }
        answer[0] = grayArray[0];
        for (int i = 1; i < grayArray.length; i++) {
            answer[i] = answer[i - 1] + grayArray[i];
        }
        return answer;
    }

    // 差分数组
    public int[] corpFlightBookings_3_GreyArray(int[][] bookings, int n) {
        int[] grayArray = new int[n + 1], answer = new int[n];
        for (int[] booking : bookings) {
            grayArray[booking[0] - 1] += booking[2];
            grayArray[booking[1]] -= booking[2];
        }
        answer[0] = grayArray[0];
        for (int i = 1; i < answer.length; i++) {
            answer[i] = answer[i - 1] + grayArray[i];
        }
        return answer;
    }
}
