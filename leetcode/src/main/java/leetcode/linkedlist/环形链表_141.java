package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * easy
 */
public class 环形链表_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode node = head;
        Set<ListNode> nodes = new HashSet<>();
        while (node != null) {
            if (nodes.contains(node)) {
                return true;
            } else {
                nodes.add(node);
                node = node.next;
            }
        }
        return false;
    }

//    // 快慢指针
//    public boolean hasCycle(ListNode head) {
//        if (head == null) {
//            return false;
//        }
//        ListNode fast = head.next;
//        ListNode slow = head;
//
//        while (fast != null && fast.next != null) {
//            if (slow == fast) {
//                return true;
//            }
//
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        return false;
//    }
}
