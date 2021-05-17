package com.ariescat.metis.leetcode;

import com.ariescat.metis.leetcode.utils.ListNode;

/**
 * 临时测试类
 */
public class Main_0002_两数相加 {

    public static void main(String[] args) {
        // [2,4,3]
        // [5,6,4]
        // [7,0,8] 输出
        ListNode l1 = createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = createList(new int[]{9, 9, 9, 9});

        ListNode ret = new Main_0002_两数相加().addTwoNumbers(l1, l2);
        while (ret != null) {
            System.err.print(ret.val + " ");
            ret = ret.next;
        }
        System.err.println();


        ret = new Main_0002_两数相加().addTwoNumbers2(l1, l2);
        while (ret != null) {
            System.err.print(ret.val + " ");
            ret = ret.next;
        }
        System.err.println();
    }

    private static ListNode createList(int[] ints) {
        ListNode first = new ListNode(ints[0]);
        ListNode next = first;
        for (int i = 1; i < ints.length; i++) {
            next.next = new ListNode(ints[i]);
            next = next.next;
        }
        return first;
    }

    /**
     * 官方思路
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode first = null, next = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            ListNode node = new ListNode(sum % 10);
            if (first == null) {
                first = node;
            } else {
                next.next = node;
            }
            next = node;
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            next.next = new ListNode(carry);
        }
        return first;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = null, next = null;
        int alter = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else {
                if (l1 != null) {
                    sum = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum = l2.val;
                    l2 = l2.next;
                }
            }
            if (alter > 0) {
                sum += alter;
                alter = 0;
            }
            if (sum >= 10) {
                alter = 1;
                sum = sum - 10;
            }
            ListNode node = new ListNode(sum);
            if (first == null) {
                first = node;
            } else {
                next.next = node;
            }
            next = node;
        }
        if (alter > 0) {
            next.next = new ListNode(alter);
        }
        return first;
    }
}
