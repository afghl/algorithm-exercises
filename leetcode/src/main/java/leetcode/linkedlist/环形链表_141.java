package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * easy
 */
public class 环形链表_141 {

    /**
     * 你能用 O(1)（即，常量）内存解决此问题吗？
     *
     */

    // 快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
