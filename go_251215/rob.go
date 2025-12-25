package main

func rob(nums []int) int {
	// 滑动窗口+动态规划
	ans := 0
	sums := make([]int, len(nums)) // 用sums数组保存走到当前步可以获取的最大值
	if len(nums) == 0 {
		return 0
	}
	for i := 0; i < len(nums); i++ {
		if i == 0 {
			sums[i] = nums[i]
		} else if i == 1 {
			sums[i] = max2(nums[1], sums[0])
		} else {
			// 这一步的最大值，要么是跳过上一步，然后加上nums[i]，要么直接取上一步的值
			sums[i] = max2(sums[i-2]+nums[i], sums[i-1])
		}
		ans = max2(sums[i], ans)
	}
	return ans
}

func max2(a, b int) int {
	if a > b {
		return a
	}
	return b
}
