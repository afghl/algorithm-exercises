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
        if (head == null || head.next == null || m < 0 || n < 0) {
            return head;
        }

        // 找到m下标的那个节点node
        int i = 1;
        ListNode prev = null, node = head;
        while (i++ < m) {
            prev = node;
            node = node.next;
        }

        ListNode reversedHead = reverseSubList(node, n - m);

        if (prev != null) {
            prev.next = reversedHead;
            return head;
        } else {
            return reversedHead;
        }
    }

    // 从node开始，翻转后面的count个节点，返回翻转后的头节点
    private ListNode reverseSubList(ListNode node, int count) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode prev = null, curr = node;

        while (count-- >= 0) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        node.next = curr;

        // 返回翻转后的头节点
        return prev;
    }

}
