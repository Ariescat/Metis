package com.ariescat.metis.leetcode;

import com.ariescat.metis.leetcode.utils.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 *
 * @date 2021-08-30, 周一
 */
public class Main_0606_根据二叉树创建字符串 {

    public static void main(String[] args) {
        Main_0606_根据二叉树创建字符串 main = new Main_0606_根据二叉树创建字符串();

        System.err.println(main.tree2str(TreeNode.build(new Integer[]{})));
        System.err.println(main.tree2str(TreeNode.build(new Integer[]{1, 2, 3, 4})));
        System.err.println(main.tree2str(TreeNode.build(new Integer[]{1, 2, 3, null, 4})));
    }

    public String tree2str(TreeNode root) {
//        return tree2str1(root);
        return tree2str2(root);
    }

    public String tree2str1(TreeNode root) {
        StringBuilder strBuilder = new StringBuilder();
        preWalk(root, strBuilder);
        String s = strBuilder.toString();
        return s.substring(1, s.length() - 1);
    }

    private void preWalk(TreeNode node, StringBuilder str) {
        if (node == null) {
            str.append("()");
            return;
        }
        str.append('(').append(node.val);
        boolean isRightNotNull = node.right != null;
        if (node.left != null) {
            preWalk(node.left, str);
        } else if (isRightNotNull) {
            str.append("()");
        }
        if (isRightNotNull) {
            preWalk(node.right, str);
        }
        str.append(')');
    }

    public String tree2str2(TreeNode root) {
        if (root == null) {
            return "";
        }
        boolean isLeftNull = root.left == null;
        boolean isRightNull = root.right == null;
        if (isLeftNull && isRightNull) {
            return root.val + "";
        }
        if (isRightNull) {
            return root.val + "(" + tree2str2(root.left) + ")";
        }
        return root.val + "(" + tree2str2(root.left) + ")(" + tree2str2(root.right) + ")";
    }
}
