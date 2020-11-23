package leetcode.linkedlist;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>
 * easy
 */
public class 回文链表_234 {

    /**
     * 请判断一个链表是否为回文链表。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->2
     * 输出: false
     * <p>
     * 示例 2:
     * <p>
     * 输入: 1->2->2->1
     * 输出: true
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        int len = 0;
        //把链表节点的值存放到栈中
        while (node != null) {
            stack.push(node.val);
            node = node.next;
            len++;
        }

        //len长度除以2
        len >>= 1;
        //然后再出栈
        while (len-- >= 0) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
