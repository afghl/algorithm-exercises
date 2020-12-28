package leetcode.dp;

/**
 * https://leetcode-cn.com/problems/house-robber/
 *
 * easy
 */
public class 打家劫舍_198 {

    /**
     * 设r[i] 为以nums[i]结束的话，可以得到的最大值
     * 那么r[i] = max(r[0], r[1], r[2], ..., r[i - 2]) + nums[i]
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] r = new int[nums.length];
        r[0] = nums[0];
        r[1] = nums[1];
        int result = Math.max(r[0], r[1]);

        for (int i = 2; i < nums.length; i++) {
            int pre = i - 2;
            int max = Math.min(r[0], r[1]);

            for (int k = 0; k <= pre; k++) {
                max = Math.max(max, r[k]);
            }
            r[i] = max + nums[i];
            result = Math.max(r[i], result);
        }

        return result;
    }

    public static void main(String[] args) {
        new 打家劫舍_198().rob(new int[]{2,7,9,3,1});
    }
}
