package leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * <p>
 * medium
 */
public class 两两交换链表中的节点_24 {

    public static void main(String[] args) {
        System.out.println(new 两两交换链表中的节点_24().swapPairs(ListNode.create(new int[]{1, 2, 3, 4, 5})));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(-1);
        ListNode pre = result;
        pre.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode a = pre.next;
            ListNode b = pre.next.next;
            ListNode next = b.next;
            // swap a and b

            pre.next = b;
            b.next = a;
            a.next = next;
            pre = a;
        }

        return result.next;
    }
}
