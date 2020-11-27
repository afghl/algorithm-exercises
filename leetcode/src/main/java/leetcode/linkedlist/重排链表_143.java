package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 *
 * medium
 */
public class 重排链表_143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        // 把链表塞到数组里
        List<ListNode> nodes = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            nodes.add(p);
            p = p.next;
        }

        // 改变数组里，每个node的指针

        int i = 0, j = nodes.size() - 1;
        while (i < j) {
            nodes.get(i).next = nodes.get(j);
            i++;
            if (i == j) {
                break;
            }
            nodes.get(j).next = nodes.get(i);
            j--;
        }
        nodes.get(i).next = null;
    }
}
