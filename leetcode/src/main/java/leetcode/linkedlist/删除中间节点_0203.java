package leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 *
 * easy
 */
public class 删除中间节点_0203 {
    /**
     * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
     * @param node
     */
    public void deleteNode(ListNode node) {
        // 用node.next的值替换当前值，直到找到最后一个，赋值为空
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
