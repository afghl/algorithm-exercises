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
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode node = result;

        while (node.next != null && node.next.next != null) {
            ListNode a = node.next;
            ListNode b = node.next.next;
            ListNode next = b.next;

            // swap a and b

            node.next = b;
            b.next = a;
            a.next = next;

            node = a;
        }

        return result.next;
    }










//
//    public ListNode swapPairs(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode result = new ListNode(-1);
//        ListNode last = result;
//        last.next = head;
//
//        while(last.next != null && last.next.next != null) {
//            ListNode a = last.next;
//            ListNode b = a.next;
//            ListNode next = b.next;
//
//            // swap a and b
//            last.next = b;
//            b.next = a;
//            a.next = next;
//
//            last = a;
//        }
//
//
//        return result.next;
//    }
}
