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

    /**
     * 返回测试数据
     * @return 测试数据
     */
    public static ListNode getTest(int length){
        int[] n = new int[length];
        for (int i = 0; i < length; i++) {
            n[i] = i;
        }
        return get(n);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.val + "=>");
            node = node.next;
        }
        if (sb.length() >= 2) {
            return sb.substring(0, sb.length() - 2);
        }
        return sb.toString();
    }
}