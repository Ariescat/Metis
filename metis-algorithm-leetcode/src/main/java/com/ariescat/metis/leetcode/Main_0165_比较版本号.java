package com.ariescat.metis.leetcode;

/**
 * https://leetcode-cn.com/problems/compare-version-numbers/
 * <p>
 *
 * @date 2021-09-01, 周三
 */
public class Main_0165_比较版本号 {

    public static void main(String[] args) {
        Main_0165_比较版本号 main = new Main_0165_比较版本号();

        System.err.println(main.compareVersion("1.01", "1.001"));
    }

    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int maxL = Math.max(split1.length, split2.length);

        for (int k = 0; k < maxL; k++) {
            int i1 = 0, i2 = 0;
            if (k < split1.length) {
                i1 = Integer.parseInt(split1[k]);
            }
            if (k < split2.length) {
                i2 = Integer.parseInt(split2[k]);
            }
            if (i1 > i2) {
                return 1;
            }
            if (i1 < i2) {
                return -1;
            }
        }
        return 0;
    }

    public int compareVersion2(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

}
