package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * medium
 */
public class 删除链表的倒数第N个节点_19 {

    /**
     * dummy
     * 
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        List<ListNode> nodes = new ArrayList<>();

        ListNode node = head;
        while (node != null) {
            nodes.add(node);
            node = node.next;
        }

        int index = nodes.size() - n;

        if (index == 0) {
            return head.next;
        } else if (index == nodes.size() - 1) {
            nodes.get(index - 1).next = null;
        } else {
            nodes.get(index - 1).next = nodes.get(index + 1);
        }
        return head;
    }
}
