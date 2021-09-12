package com.ariescat.metis.leetcode.utils;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode build(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode[] nodes = new TreeNode[arr.length];
        nodes[0] = new TreeNode(arr[0]);
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == null) continue;
                // 父索引
                int pIndex = (i - 1) / 2;
                TreeNode node = nodes[i] = new TreeNode(arr[i]);
                if (i % 2 == 1) {
                    // left
                    nodes[pIndex].left = node;
                } else {
                    // right
                    nodes[pIndex].right = node;
                }
            }
        }
        return nodes[0];
    }
}
