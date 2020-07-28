package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 
 * easy
 */
public class 数组中重复的数字_剑指_Offer_03 {
    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * @param nums
     * @return
     */
    // 字典
    public int findRepeatNumber(int[] nums) {
        Set<Integer> existed = new HashSet<>();

        for (int num : nums) {
            if (existed.contains(num)) {
                return num;
            } else {
                existed.add(num);
            }
        }

        return -1;
    }

    // 原地置换
    public int findRepeatNumber2(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
