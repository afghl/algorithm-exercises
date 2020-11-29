package leetcode.linkedlist;

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
}
