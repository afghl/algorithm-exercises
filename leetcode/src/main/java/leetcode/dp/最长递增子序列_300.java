package leetcode.dp;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * medium
 */
public class 最长递增子序列_300 {

    public int lengthOfLIS(int[] nums) {
        /**
         * 定义r[i] 为以nums[i]结尾的最大子序列的长度
         * 则有r[i] = max(r[0], r[1], ... r[i - 1]) + 1
         */

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] results = new int[nums.length];
        results[0] = 1;
        int ans = 1;

        for (int i = 1; i < nums.length; i++) {
            int maxPrev = 0;
            for (int k = 0; k < i; k++)
                if (nums[k] < nums[i])
                    maxPrev = Math.max(maxPrev, results[k]);

            results[i] = maxPrev + 1;
            ans = Math.max(results[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new 最长递增子序列_300().lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }
}
