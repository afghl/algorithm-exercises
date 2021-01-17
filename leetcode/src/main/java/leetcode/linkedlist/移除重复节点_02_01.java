package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 *
 * easy
 */
public class 移除重复节点_02_01 {

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> nodes = new HashSet<>();
        nodes.add(head.val);

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (nodes.contains(curr.next.val)) {
                // remove curr.next
                curr.next = curr.next.next;
            } else {
                nodes.add(curr.next.val);
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new 移除重复节点_02_01().removeDuplicateNodes(ListNode.create(new int[]{1, 2, 3, 3, 2, 1}));
        System.out.println(listNode);
    }
}
