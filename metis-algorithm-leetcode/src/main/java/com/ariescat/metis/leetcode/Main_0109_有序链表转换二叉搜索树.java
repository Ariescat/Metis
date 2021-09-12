package com.ariescat.metis.leetcode;

import com.ariescat.metis.leetcode.utils.ListNode;
import com.ariescat.metis.leetcode.utils.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * @author Ariescat
 * @version 2020/8/18 16:24
 */
public class Main_0109_有序链表转换二叉搜索树 {

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode midNode = getMidNode(head, tail);
        TreeNode root = new TreeNode(midNode.val);
        root.left = buildTree(head, midNode);
        root.right = buildTree(midNode.next, tail);
        return root;
    }

    public ListNode getMidNode(ListNode head, ListNode tail) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
