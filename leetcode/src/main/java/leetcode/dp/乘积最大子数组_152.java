package leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * medium
 */
public class 乘积最大子数组_152 {
    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     *
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     */
    public int maxProduct(int[] nums) {
        /**
         * 定义max[i]为以nums[i]结尾的子数组的最大值，min[i] 为最小值
         * 则max[i] = nums[i] >= 0 ? max[i - 1] * nums[i] : min[i - 1] * nums[i]
         * min[i]同理
         */

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];
        int ans = max[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                max[i] = 0;
                min[i] = 0;
            } else if (nums[i] > 0) {
                max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(min[i - 1] * nums[i], nums[i]);
            } else {
                max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(max[i - 1] * nums[i], nums[i]);
            }
            ans = Math.max(ans, max[i]);
        }

        return ans;
    }

}
