package leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class 移除链表元素_203 {


    public static void main(String[] args) {
        System.out.println(new 移除链表元素_203().removeElements(ListNode.create(new int[] {1,2,2,1}), 2));
    }
    /**
     * 删除链表中等于给定值 val 的所有节点。
     *
     * 示例:
     *
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        // 先移除头部的元素
        while (head != null && head.val == val) head = head.next;
        if (head == null) {
            return null;
        }

        ListNode node = head;

        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }
}
