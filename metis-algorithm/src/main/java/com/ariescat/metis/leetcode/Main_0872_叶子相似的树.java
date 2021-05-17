package com.ariescat.metis.leetcode;

import com.ariescat.metis.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class Main_0872_叶子相似的树 {

    public static void main(String[] args) {

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> arr1 = new ArrayList<>();
        fill(root1, arr1);

        List<Integer> arr2 = new ArrayList<>();
        fill(root2, arr2);

        if (arr1.size() != arr2.size()) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (!arr1.get(i).equals(arr2.get(i))) {
                return false;
            }
        }

        return true;
    }

    private void fill(TreeNode root, List<Integer> arr) {
        if (root.left == null && root.right == null) {
            arr.add(root.val);
            return;
        }
        if (root.left != null) {
            fill(root.left, arr);
        }
        if (root.right != null) {
            fill(root.right, arr);
        }
    }
}
