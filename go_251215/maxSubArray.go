package main

func maxSubArray(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	// 记录以当前为作为结尾的话，能够取得的和最大值
	maxEnd := make([]int, len(nums))
	maxEnd[0] = nums[0]
	ans := nums[0]
	for i := 1; i < len(nums); i++ {
		maxEnd[i] = max(nums[i], nums[i]+maxEnd[i-1])
		ans = max(ans, maxEnd[i])
	}
	return ans
}
