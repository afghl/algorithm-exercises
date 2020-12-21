package leetcode.dp;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * <p>
 * easy
 */
public class 使用最小花费爬楼梯_746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) {
            return -1;
        }

        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static void main(String[] args) {
        System.out.println(new 使用最小花费爬楼梯_746().minCostClimbingStairs(new int[] {10, 15, 20}));
        System.out.println(new 使用最小花费爬楼梯_746().minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(new 使用最小花费爬楼梯_746().minCostClimbingStairs(new int[]{0, 2, 2, 1}));
    }
}
