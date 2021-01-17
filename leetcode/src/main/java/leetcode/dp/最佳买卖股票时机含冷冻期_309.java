package leetcode.dp;

import static java.lang.Math.max;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * <p>
 * medium
 */
public class 最佳买卖股票时机含冷冻期_309 {

    public int maxProfit(int[] prices) {
        // 有三个数组，sell[i]是假设在第i天卖了的最大收益，buy[i]是在第i天持有的收益，cold[i]是在第i天处于冷冻期的收益

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        int[] cold = new int[prices.length];

        // 易得：sell[i] = max(buy[i - 1] + prices[i], sell[i - 1])
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell[i] = max(buy[i - 1] + prices[i], sell[i - 1]);
            buy[i] = max(cold[i - 1] - prices[i], buy[i - 1]);
            cold[i] = max(sell[i - 1], buy[i - 1]);
        }
        return max(sell[prices.length - 1], buy[prices.length - 1]);
    }
}
