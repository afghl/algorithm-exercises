package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-majority-element-lcci/
 *
 * easy
 */
public class 面试题_17_10_主要元素 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();

        int majorityNum = -1;
        for (int num : nums) {
            Integer count = numCount.getOrDefault(num, 0) + 1;
            numCount.put(num, count);

            if (count > nums.length / 2) {
                majorityNum = num;
            }
        }

        return majorityNum;
    }

    public static void main(String[] args) {
        new 面试题_17_10_主要元素().majorityElement(new int[] {3, 2, 3});
    }
}
