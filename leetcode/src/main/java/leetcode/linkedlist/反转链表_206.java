package leetcode.linkedlist;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * easy
 */
public class 反转链表_206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
//        new HashMap<>().containsKey();
        return prev;
    }

    /**
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head, node = head.next;

        while (node != null) {
            ListNode next = node.next;

            node.next = prev;

            node = next;
            prev = node;
        }
        return head;
    }















//    public ListNode reverseList(ListNode head) {
//        return doReverse(null, head);
//    }
//
//    private ListNode doReverse(ListNode prev, ListNode node) {
//        if (node == null) {
//            return prev;
//        }
//        ListNode next = node.next;
//        node.next = prev;
//        return doReverse(node, next);
//    }
}
