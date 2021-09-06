package com.ariescat.metis.leetcode;

import com.ariescat.metis.leetcode.utils.ListNode;

/**
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 * @date 2021-09-06, 周一
 */
public class Main_剑指Offer_25_合并两个排序的链表 {

    public static void main(String[] args) {
        System.err.println(Main_剑指Offer_25_合并两个排序的链表.mergeTwoLists(ListNode.build(new Integer[]{1, 2, 4}), ListNode.build(new Integer[]{1, 3, 4})));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0), ret = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                newNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            newNode = newNode.next;
        }
        newNode.next = l1 == null ? l2 : l1;
        return ret.next;
    }
}
