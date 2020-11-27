package leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * medium
 */
public class 两两交换链表中的节点_24 {

    public static void main(String[] args) {
        System.out.println(new 两两交换链表中的节点_24().swapPairs(ListNode.create(new int[] {1,2,3,4,5})));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(-1);
        ListNode last = result;
        ListNode pre = head;
        ListNode curr = head.next;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            // add to result list
            pre.next = null;
            last.next = curr;
            curr.next = pre;
            last = pre;

            if (next == null) {
                break;
            }
            pre = next;
            curr = next.next;
        }

        if (next != null) {
            last.next = next;
        }


        return result.next;
    }
}
