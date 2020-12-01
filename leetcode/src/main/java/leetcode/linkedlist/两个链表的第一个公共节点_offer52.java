package leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 * easy
 */
public class 两个链表的第一个公共节点_offer52 {

    /**
     * 双指针
     * 假设listA和listB有交集于listC
     * 则：
     * len(listA) = A + C
     * len(listB) = B + C
     * 两个指针p + q分别遍历完A + C + B，则会相遇，且相遇在listC的起点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;

        while (q != p) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }

        return q;
    }
}
