package com.wack.code;

public class A2两数相加 {
    public static void main(String[] args) {
        int[] data1 = new int[]{1};
        int[] data2 = new int[]{9, 9, 9, 9, 9, 9, 9, 9};

        ListNode data = addTwoNumbers(toListNode(data1), toListNode(data2));
        while (data != null) {
            System.out.print("-->" + data.val);
            data = data.next;
        }
    }

    public static ListNode toListNode(int[] datas) {
        ListNode node = null;
        ListNode curr;
        for (int i = datas.length - 1; i >= 0; i--) {
            curr = new ListNode(datas[i]);
            curr.next = node;
            node = curr;
        }
        return node;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode after = null;
        ListNode curr = null;
        int flag = 0;
        int v;
        while (l1 != null) {
            v = l1.val + (l2 != null ? l2.val : 0) + flag;
            flag = v / 10;
            curr = new ListNode(v < 10 ? v : v % 10);
            if (head == null) head = curr;
            if (after != null) after.next = curr;
            after = curr;
            l1 = l1.next;
            l2 = l2 != null ? l2.next : null;
        }
        if (l2 != null) {
            if (flag != 0) {
                while (l2 != null) {
                    v = l2.val + flag;
                    flag = v / 10;
                    curr = new ListNode(v < 10 ? v : v % 10);
                    if (head == null) head = curr;
                    if (after != null) after.next = curr;
                    after = curr;
                    l2 = l2.next;
                }
            } else {
                after.next = l2;
            }
        }
        if (flag != 0) {
            after.next = new ListNode(flag);
        }
        return head;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int v = v1 + v2 + carry;
            carry = v / 10;
            curr.next = new ListNode(v % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) curr.next = new ListNode(carry);
        return head.next;
    }
}
