package leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 * easy
 */
public class 返回倒数第_k_个节点_0202 {

    /**
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     *
     * 注意：本题相对原题稍作改动
     *
     * 示例：
     *
     * 输入： 1->2->3->4->5 和 k = 2
     * 输出： 4
     * 说明：
     *
     * 给定的 k 保证是有效的。
     *
     *  @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        // get length
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        int pos = length - k;
        int i = 0;
        node = head;
        while (i++ <= pos)
            node = node.next;
        return node.val;
    }


}
