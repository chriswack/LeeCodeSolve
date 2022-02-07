package leetcode.editor.cn;

import leetcode.editor.cn.entity.ListNode;
import leetcode.editor.cn.entity.Util;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class A24两两交换链表中的节点 {
    public static void main(String[] args) {

        int[] n = new int[10];
        for (int i = 0; i < 10; i++) {
            n[i] = i;
        }

        ListNode head = ListNode.get(n);
        long start = System.currentTimeMillis();
        ListNode swapPairs = new A24两两交换链表中的节点().swapPairs(head);
        System.out.println((System.currentTimeMillis() - start) + "ms");
        System.out.println(Util.toStr(swapPairs));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0, head);
        ListNode current = node;
        while (current.next != null && current.next.next != null) {

            System.out.println("current=>"+Util.toStr(node));
            ListNode first = current.next;//第一个
            ListNode secord = first.next;//第二个
            first.next = secord.next;
            secord.next = first;
            current.next = secord;

            current = first;
        }
        return node.next;
    }
}