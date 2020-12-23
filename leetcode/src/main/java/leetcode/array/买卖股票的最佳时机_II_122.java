package leetcode.array;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * easy
 */
public class 买卖股票的最佳时机_II_122 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int boughtPrice = 0;
        boolean bought = false;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == prices.length - 1) {
                if (bought)
                    profit += prices[i] - boughtPrice;
                break;
            }

            // 如果明天会跌
            if (prices[i] > prices[i + 1] && bought) {
                // 卖
                profit += prices[i] - boughtPrice;
                bought = false;
            }

            // 如果明天会涨
            if (prices[i] < prices[i + 1] && !bought) {
                // 买
                boughtPrice = prices[i];
                bought = true;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new 买卖股票的最佳时机_II_122().maxProfit(new int[] { 7,1,5,3,6,4 }));
    }
}
