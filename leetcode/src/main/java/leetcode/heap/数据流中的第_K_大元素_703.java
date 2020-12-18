package leetcode.heap;

import java.util.PriorityQueue;

public class 数据流中的第_K_大元素_703 {
}

class KthLargest {

    PriorityQueue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(q.size() < k) {
            q.offer(val);
        }
        else if(q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}