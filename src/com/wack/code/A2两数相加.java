package com.wack.code;

import com.wack.code.entity.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
