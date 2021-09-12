package com.ariescat.metis.leetcode;

import com.ariescat.metis.leetcode.utils.ListNode;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * @date 2021-09-06, 周一
 */
public class Main_剑指Offer_24_反转链表 {

    public static void main(String[] args) {
        Main_剑指Offer_24_反转链表 main = new Main_剑指Offer_24_反转链表();
        System.err.println(main.reverseList2(ListNode.build(new Integer[]{1, 2, 3, 4, 5})));
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode node) {
        // 1 2 3 4 5
        if (node == null || node.next == null) {
            return node;
        }
        ListNode newNode = reverseList2(node.next);
        node.next.next = node;
        node.next = null;
        return newNode;
    }

}
