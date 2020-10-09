package com.ariescat.metis.algorithm.动态规划.最长公共子序列;

/**
 * @author Ariescat
 * @version 2020/3/26 12:27
 */
public class Test {

    public static void main(String[] args) {
        String str1 = "1A2C3D4B560";
        String str2 = "B1D23CA45B6A";
        int lcs = findLCS(str1, str1.length(), str2, str2.length());
        System.err.println(lcs);
    }

    public static int findLCS(String A, int n, String B, int m) {
        // write code here
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }
}
