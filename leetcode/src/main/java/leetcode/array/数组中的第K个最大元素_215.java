package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * medium
 */
public class 数组中的第K个最大元素_215 {
    /**
     * 1. 排序
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


//    public int findKthLargest(int[] nums, int k) {
//        if (nums == null) {
//            return -1;
//        }
//
//
//    }
}
