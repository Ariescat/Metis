package com.ariescat.metis.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/decode-xored-permutation/
 *
 * <pre>
 * 1734. 解码异或后的排列
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 *
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *
 *
 * 提示：
 *
 * 3 <= n < 105
 * n 是奇数。
 * encoded.length == n - 1
 * </pre>
 */
public class Main_1734_解码异或后的排列 {

    public static void main(String[] args) {
        Main_1734_解码异或后的排列 test = new Main_1734_解码异或后的排列();
        System.out.println(Arrays.toString(test.decode(new int[]{3, 1})));
        System.out.println(Arrays.toString(test.decode(new int[]{6, 5, 4, 6})));
    }

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;

        // perm_0 ^ perm_1 ^ ... ^ perm_n
        // 前n个正整数的异或
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total = total ^ i;
        }

        // perm_1 ^ ... ^ perm_n
        // encoded的奇数下标异或
        int odd = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            odd = odd ^ encoded[i];
        }

        // encoded[i−1]=perm[i−1]^perm[i] => perm[i]=perm[i−1]^encoded[i−1]
        int[] perm = new int[n];
        perm[0] = total ^ odd;
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }
        return perm;
    }
}
