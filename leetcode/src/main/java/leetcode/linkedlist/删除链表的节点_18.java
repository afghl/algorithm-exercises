package leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * easy
 */
public class 删除链表的节点_18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode curr = result;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;

            if (next.val == val) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        return result.next;
    }
}
