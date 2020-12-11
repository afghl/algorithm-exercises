package leetcode.array;

/**
 * https://leetcode-cn.com/problems/running-sum-of-1d-array/
 *
 * easy
 */
public class 一维数组的动态和_1480 {

    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] result = new int[nums.length];

        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i] + result[i - 1];
        }

        return result;
    }
}
