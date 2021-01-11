package leetcode.dp;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * <p>
 * medium
 */
public class 零钱兑换_322 {

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * 示例 1：
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     * <p>
     * 输入：coins = [2], amount = 3
     * 输出：-1
     */
//    public int coinChange(int[] coins, int amount) {
//        /**
//         * 假设f(n) 就是凑够n的个数的最小值
//         * 所以计算f(n)要从f(n-1)或者f(n-2)...找出来
//         * f(n) = min(f(n-1), f(n-2), f(n-3)...f(0)) + 1
//         */
//
//        if (coins == null || coins.length <= 0) {
//            return -1;
//        }
//        int[] result = new int[amount + 1];
//
//        result[0] = 0;
//        int i = 1;
//        while (i <= amount) {
//            int min = Integer.MAX_VALUE;
//
//            // f(n) = min(f(n-1), f(n-2), f(n-3)...f(0)) + 1
//            // 并且要判断这个最小的f(n-k)能有一步跨到f(n)这里来的
//            // 所以应该反过来，从面值去取
//            for (int coin : coins) {
//                if (i < coin) {
//                    continue;
//                }
//                if (result[i - coin] < min) {
//                    min = result[i - coin] + 1;
//                }
//            }
//
//            result[i] = min;
//
//            i++;
//        }
//
//        return result[amount] == Integer.MAX_VALUE ? -1 : result[amount];
//    }

    // 自己写次
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length <= 0 || amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        int[] result = new int[amount + 1];
        result[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // dp[i] = min(di[i-coins[k]]...) + 1
            int max = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                max = Math.min(result[i - coin], max);
            }
            result[i] = max == Integer.MAX_VALUE ? max : max + 1;
        }

        return result[amount] == Integer.MAX_VALUE ? -1 : result[amount];
    }

    public static void main(String[] args) {
        int i = new 零钱兑换_322().coinChange(new int[]{2, 5}, 11);
        System.out.println(i);
    }

}
