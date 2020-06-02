package com.wack.code.entity;

/**
 * 单相链表
 */
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

    public static ListNode get(int... num) {
        ListNode head = new ListNode();
        ListNode curr = head;
        for (int i = 0; i < num.length; i++) {
            curr.next = new ListNode(num[i]);
            curr = curr.next;
        }
        return head.next;
    }

}