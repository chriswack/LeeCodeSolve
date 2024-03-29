package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;
import leetcode.editor.cn.entity.Util;
import leetcode.editor.cn.util.Tool;

/**
 * 206. 反转链表
 * 难度
 * 简单
 * <p>
 * 1433
 * <p>
 * 收藏
 * <p>
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

public class A206反转链表 {
    public static void main(String[] args) {
        ListNode head = ListNode.getTest(12);
        System.out.println(Util.toStr(head));
        Tool.costTime(() -> {
            ListNode swapPairs = new A206反转链表().reverseList(head);
            System.out.println(Util.toStr(swapPairs));
        });

    }

    /**
     * 翻转链表-递归
     *
     * @param head 头元素
     * @return 结果
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    /**
     * 翻转链表-循环
     *
     * @param head 头元素
     * @return 结果
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}