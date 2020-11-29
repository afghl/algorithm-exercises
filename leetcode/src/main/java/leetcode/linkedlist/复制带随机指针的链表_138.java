package leetcode.linkedlist;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * medium
 */
public class 复制带随机指针的链表_138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
        public static Node create(int[] arr) {
            Node result = new Node(-1);
            Node last = result;

            for (int i : arr) {
                last.next = new Node(i);
                last = last.next;
            }

            return result.next;
        }
    }

    public static void main(String[] args) {
        System.out.println(new 复制带随机指针的链表_138().copyRandomList(Node.create(new int [] {1,2,3,4,5})));
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node result = new Node(-1);
        Node last = result;
        Node node = head;

        Map<Node, List<Node>> randomPointMap = new HashMap<>();
        Map<Node, Node> nodeMap = new HashMap<>();

        while (node != null) {
            Node copy = new Node(node.val);
            nodeMap.put(node, copy);
            last.next = copy;

            // 处理random指针
            if (node.random != null) {
                Node random = node.random;
                addToMap(random, randomPointMap, copy);
            }

            last = last.next;
            node = node.next;
        }

        if (!randomPointMap.isEmpty()) {
            randomPointMap.forEach((random, nodes) -> {
                for (Node n : nodes) {
                    n.random = nodeMap.get(random);
                }
            });
        }

        return result.next;
    }

    private void addToMap(Node random, Map<Node, List<Node>> randomMap, Node copy) {
        if (randomMap.containsKey(random)) {
            randomMap.get(random).add(copy);
        } else {
            List<Node> list = new ArrayList<>();
            list.add(copy);
            randomMap.put(random, list);
        }
    }
}
