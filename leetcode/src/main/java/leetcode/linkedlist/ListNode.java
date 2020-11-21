package leetcode.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static ListNode create(int[] arr) {
        ListNode result = new ListNode(-1);
        ListNode last = result;

        for (int i : arr) {
            last.next = new ListNode(i);
            last = last.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        System.out.println(create(new int[] {0,8,6,5,6,8,3,5,7}));
    }
}