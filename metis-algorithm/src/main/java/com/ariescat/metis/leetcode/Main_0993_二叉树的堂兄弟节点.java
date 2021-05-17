package com.ariescat.metis.leetcode;

import com.ariescat.metis.leetcode.utils.TreeNode;

/**
 * 993. 二叉树的堂兄弟节点
 * <pre>
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * </pre>
 */
public class Main_0993_二叉树的堂兄弟节点 {

    public static void main(String[] args) {
        Main_0993_二叉树的堂兄弟节点 test = new Main_0993_二叉树的堂兄弟节点();

        TreeNode treeNode = TreeNode.build(new Integer[]{1, 2, 3, null, 4, null, 5});
        boolean ret = test.isCousins(treeNode, 5, 4);
        System.err.println(ret);
    }

    // x 的信息
    int x;
    TreeNode xParent;
    int xDepth;
    boolean xFound = false;

    // y 的信息
    int y;
    TreeNode yParent;
    int yDepth;
    boolean yFound = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }

    private void dfs(TreeNode node, int depth, TreeNode parent) {
        if (node == null) {
            return;
        }
        if (this.x == node.val) {
            this.xParent = parent;
            this.xDepth = depth;
            this.xFound = true;
        } else if (this.y == node.val) {
            this.yParent = parent;
            this.yDepth = depth;
            this.yFound = true;
        }

        if (xFound && yFound) {
            return;
        }

        dfs(node.left, depth + 1, node);
        if (xFound && yFound) {
            return;
        }
        dfs(node.right, depth + 1, node);
        if (xFound && yFound) {
            return;
        }
    }
}
