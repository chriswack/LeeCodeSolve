package com.wack.code;

import com.wack.code.entity.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class A23合并K个排序链表 {
    public static void main(String[] args) {

        int len = 3;
        ListNode[] nodes = new ListNode[len];
        for (int i = 0; i < len; i++) {
            int[] n = new int[1000];
            for (int j = 0; j < n.length; j++) {
                n[j] = j * len + i;
            }
            nodes[i] = ListNode.get(n);
        }

        long start = System.currentTimeMillis();
        ListNode mergeTwoLists = new A23合并K个排序链表().mergeKLists2(nodes);
        System.out.println((System.currentTimeMillis() - start) + "ms");
        while (mergeTwoLists != null) {
            System.out.print(mergeTwoLists.val + "=>");
            mergeTwoLists = mergeTwoLists.next;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode min = null;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            if (curr != null && (min == null || curr.val < min.val)) {
                min = curr;
                index = i;
            }
        }
        if (min != null) {
            lists[index] = min.next;
        } else {
            return null;
        }
        min.next = mergeKLists(lists);
        return min;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null) queue.add(curr.next);
        }

        return head.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode head = null;
        for (int i = 0; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }


    //递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
