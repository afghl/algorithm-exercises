package leetcode.pending;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * hard
 */
public class 滑动窗口最大值_239 {

    // 思路：用一个队列来记录当前最大值，那么移动的过程就是这个队列进队出队的过程
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        Queue<Integer> q = new LinkedList<>();

        return null;
    }
}
