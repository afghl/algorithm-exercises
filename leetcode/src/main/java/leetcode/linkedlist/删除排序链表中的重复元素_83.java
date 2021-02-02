package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * easy
 */
public class 删除排序链表中的重复元素_83 {


    public static void main(String[] args) {

    }
    /**
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode node = head.next;

        while (node != null) {
            // 如果重复了，删除当前结点
            if (node.val == prev.val) {
                prev.next = node.next;
                node = node.next;
            } else {
                prev = node;
                node = node.next;
            }
        }

        return head;
    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> set = new HashSet<>();
        set.add(head.val);

        ListNode curr = head;

        while (curr.next != null) {
            if (set.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                set.add(curr.next.val);
                curr = curr.next;
            }
        }

        return head;
    }
}
