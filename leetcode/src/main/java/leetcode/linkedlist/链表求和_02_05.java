package leetcode.linkedlist;

import com.sun.media.sound.AiffFileReader;

/**
 * https://leetcode-cn.com/problems/sum-lists-lcci/
 *
 * medium
 */
public class 链表求和_02_05 {

    /**
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     * 这些数位是反向存放的，也就是个位排在链表首部。
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     * 示例：
     *
     * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     * 输出：2 -> 1 -> 9，即912
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode result = new ListNode(-1);

        ListNode p1 = l1, p2 = l2, r = result;
        // 进位
        int addToNext = 0;
        while (p1 != null || p2 != null || addToNext > 0) {
            int num1 = p1 == null ? 0 : p1.val;
            int num2 = p2 == null ? 0 : p2.val;
            int sum = num1 + num2 + addToNext;
            addToNext = sum >= 20 ? 2 : sum >= 10 ? 1 : 0;
            r.next = new ListNode(sum - addToNext * 10);
            r = r.next;
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        System.out.println(new 链表求和_02_05().addTwoNumbers(
                ListNode.create(new int[]{7, 1, 6}),
                ListNode.create(new int[]{5, 9, 2})
        ));
    }
}
