package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;
import leetcode.editor.cn.entity.Util;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class A21合并两个有序链表 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int[] n1 = new int[10];
        int[] n2 = new int[10];
        for (int i = 0; i < n1.length; i++) {
            n1[i] = i * 2;
            n2[i] = i * 2 + 1;
        }

        ListNode mergeTwoLists = new A21合并两个有序链表().mergeTwoLists1(ListNode.get(n1), ListNode.get(n2));
        System.out.println((System.currentTimeMillis() - start) + "ms");
        System.out.println(Util.toStr(mergeTwoLists));
    }

    //递归
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    //基础算法 单独判断大小合并
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return head.next;
    }


}
