package com.ariescat.metis.leetcode;

import com.ariescat.metis.leetcode.utils.ListNode;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * @date 2021-09-06, 周一
 */
public class Main_剑指Offer_22_链表中倒数第k个节点 {
    public static void main(String[] args) {
        Main_剑指Offer_22_链表中倒数第k个节点 main = new Main_剑指Offer_22_链表中倒数第k个节点();
        main.getKthFromEnd3(ListNode.build(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}), 2);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode next = head;
        int length = 0;
        while (next != null) {
            length++;
            next = next.next;
        }

        next = head;
        int n = length - k + 1;
        length = 0;
        while (next != null) {
            length++;
            if (length == n) {
                return next;
            }
            next = next.next;
        }
        return next;
    }

    private ListNode getKthFromEnd2(ListNode head, int k) {
        int n = 0;
        ListNode node = null;

        for (node = head; node != null; node = node.next) {
            n++;
        }
        for (node = head; n > k; n--) {
            node = node.next;
        }
        return node;
    }

    private ListNode getKthFromEnd3(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
