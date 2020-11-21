package leetcode.array;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * easy
 */
public class 买卖股票的最佳时机_121 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int min = prices[0];
        int maxEarn = 0;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                maxEarn = Math.max(maxEarn, price - min);
            }
        }

        return maxEarn;
    }
}
