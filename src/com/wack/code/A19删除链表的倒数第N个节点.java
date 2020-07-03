package com.wack.code;

import com.wack.code.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A19删除链表的倒数第N个节点 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        ListNode head = null;
        for (int i = 5; i >= 0; i--) {
            ListNode node = new ListNode(i);
            node.next = head;
            head = node;
        }
        ListNode res = head;
        while (res != null) {
            System.out.print(res.val + "=>");
            res = res.next;
        }
        System.out.println("结果");
        res = new A19删除链表的倒数第N个节点().removeNthFromEnd2(head, 2);
        while (res != null) {
            System.out.print(res.val + "=>");
            res = res.next;
        }

        System.out.println(System.currentTimeMillis() - start + "ms");

    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode currNode = head;
        while (currNode != null) {
            nodes.add(0, currNode);
            currNode = currNode.next;
        }
        currNode = nodes.get(n - 1);
        if (head == currNode) {//删除头节点
            head = head.next;
        } else {
            nodes.get(n).next = currNode.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode targetNode = newNode;//目标节点
        ListNode currNode = newNode;//当前节点
        for (int i = 0; i < n + 1; i++) {//先循环跳转到相对节点
            currNode = currNode.next;
        }
        while (currNode != null) {
            currNode = currNode.next;
            targetNode = targetNode.next;
        }

        targetNode.next = targetNode.next.next;
        return newNode.next;
    }

}
