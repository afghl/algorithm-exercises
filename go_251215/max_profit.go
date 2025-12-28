package main

// 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

// 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。然而，你可以在 同一天 多次买卖该股票，但要确保你持有的股票不超过一股。

// 返回 你能获得的 最大 利润 。
func maxProfit(prices []int) int {
	return 0
}

// 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
func maxProfit1(prices []int) int {
	if len(prices) < 1 {
		return 0
	}
	min, maxProfit := prices[0], -1
	for i := 1; i < len(prices); i++ {
		profit := prices[i] - min
		if profit > maxProfit {
			maxProfit = profit
		}
		if prices[i] < min {
			min = prices[i]
		}
	}
	if maxProfit > 0 {
		return maxProfit
	} else {
		return 0
	}
}
