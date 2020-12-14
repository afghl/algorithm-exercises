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
    private Map<Integer, DLinkedNode> map;
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

    }

    public void put(int key, int value) {
        
    }
}
