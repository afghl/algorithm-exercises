package leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/partition-list/
 *
 * medium
 */
public class 分隔链表_86 {


    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        
    }

    /**
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     *
     * 你应当保留两个分区中每个节点的初始相对位置。
     *
     * 示例:
     *
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     *
     */
    public ListNode partition(ListNode head, int x) {
        ListNode maxHead = new ListNode(-1);
        ListNode minHead = new ListNode(-1);
        ListNode p = maxHead, q = minHead;
        ListNode node = head;

        while (node != null) {
            if (node.val >= x) {
                p.next = node;
                p = p.next;
            } else {
                q.next = node;
                q = q.next;
            }
            node = node.next;
        }

        q.next = maxHead.next;
        p.next = null;

        return minHead.next;
    }

    public static void main(String[] args) {
        ListNode result = new 分隔链表_86().partition(ListNode.create(new int[]{1,4,3,2,5,2}), 3);
        System.out.println(result);
    }
}
