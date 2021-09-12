package com.ariescat.metis.leetcode.utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode build(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return new ListNode();
        }
        ListNode head = new ListNode(arr[0]);
        ListNode next = head;
        for (int i = 1; i < arr.length; i++) {
            next = next.next = new ListNode(arr[i]);
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append(val);
        ListNode next = this.next;
        while (next != null) {
            ret.append(" ").append(next.val);
            next = next.next;
        }
        return ret.toString();
    }
}
