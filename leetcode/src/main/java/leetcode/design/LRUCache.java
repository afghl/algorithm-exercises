package leetcode.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache-lcci/
 *
 * medium
 */
class LRUCache {

    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer/* key */, DLinkedNode> map;
    private int capacity;
    private int size;


    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("capacity > 0");
        }
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToTop(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 如果已经在map里，移动到头位
        DLinkedNode node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToTop(node);
        // 如果不在map里，新增一个node，移动到头位
        } else {
            node = new DLinkedNode(key, value);
            this.size++;
            addToTop(node);
            map.put(key, node);
        }

        // 判断capacity，回收
        if (size > capacity) {
            DLinkedNode last = tail.prev;
            remove(last);
            map.remove(last.key);
            size--;
        }
    }

    private void addToTop(DLinkedNode node) {
        DLinkedNode next = head.next;

        next.prev = node;
        head.next = node;
        node.next = next;
        node.prev = head;
    }

    private void moveToTop(DLinkedNode node) {
        remove(node);
        addToTop(node);
    }

    private void remove(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
