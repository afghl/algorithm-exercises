package leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * <p>
 * easy
 */
public class 反转链表2_92 {

    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[]{1,2,3,4, 5});
        ListNode reversed = new 反转链表2_92().reverseBetween(head, 2, 4);
        System.out.println(reversed);
    }

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * <p>
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        int i = 1;
        ListNode prev = null;
        ListNode curr = head;
        while (i++ < m) {
            prev = curr;
            curr = curr.next;
        }

        ListNode reversed = reverse(curr, n - m);

        if (prev != null) {
            prev.next = reversed;
        } else {
            return reversed;
        }

        return head;
    }

    private ListNode reverse(ListNode head, int count) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (count-- >= 0) {
            next = curr.next; // 2
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = curr;

        return prev;
    }
}
