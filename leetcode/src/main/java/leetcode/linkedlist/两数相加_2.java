package leetcode.linkedlist;

public class 两数相加_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) return l2;
        if (l2.val == 0) return l1;

        ListNode p1 = l1, p2 = l2;
        int tmp = 0; // 进位
        ListNode result = new ListNode(-1);
        ListNode last = result;
        while (p1 != null || p2 != null || tmp != 0) {
            int val1 = p1 != null ? p1.val : 0;
            int val2 = p2 != null ? p2.val : 0;
            int sum = val1 + val2 + tmp;
            int add = sum >= 10 ? sum - 10 : sum;
            tmp = sum >= 10 ? 1 : 0;

            last.next = new ListNode(add);
            last = last.next;


            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        return result.next;
    }
}
