package leetcode.linkedlist;

/**
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * medium
 */
public class 扁平化多级双向链表_430 {
    public Node flatten(Node head) {
        Node p = head;

        // 向后遍历
        while (p != null) {
            if (p.child != null) {
                Node next = p.next;
                // 存在子节点，将child的pre指向p，p的next指向child
                Node flatten = flatten(p.child);
                p.next = flatten;
                p.next.prev = p;
                p.child = null;
                // 将原来的next 和这个flatten出来的链表连起来
                if (next != null) {
                    Node lastOfFlatten = flatten;
                    while (lastOfFlatten.next != null) {
                        lastOfFlatten = lastOfFlatten.next;
                    }

                    next.prev = lastOfFlatten;
                    lastOfFlatten.next = next;
                }
                p = next;
            } else {
                p = p.next;
            }
        }

        return head;
    }
}
