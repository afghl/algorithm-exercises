package leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * easy
 */
public class 删除链表中的节点_237 {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;

        node.val = next.val;
        node.next = next.next;
    }
}
