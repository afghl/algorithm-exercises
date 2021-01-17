package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * easy
 */
public class 从尾到头打印链表_06 {

    public static void main(String[] args) {
        new 从尾到头打印链表_06().reversePrint(ListNode.create(new int[]{1,2,3,4}));
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> result = new ArrayList<>();
        doReverse(head, result);

        System.out.println(result);

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    private void doReverse(ListNode node, List<Integer> l) {
        if (node == null) {
            return;
        }

        doReverse(node.next, l);
        l.add(node.val);
    }
}
