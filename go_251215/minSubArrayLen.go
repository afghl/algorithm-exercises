package main

import (
	"math"
)

func minSubArrayLen(target int, nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	minLength := math.MaxInt
	l, r, sum := 0, 0, 0
	// 移动右侧
	for ; r < len(nums); r++ {
		sum += nums[r]
		// 收缩左侧
		for l <= r && sum >= target {
			if sum-nums[l] >= target {
				sum -= nums[l]
				l++
			} else {
				break
			}
		}
		if sum >= target {
			minLength = getmin2(r-l+1, minLength)
		}
	}
	if minLength < math.MaxInt {
		return minLength
	} else {
		return 0
	}
}
func getmin2(a, b int) int {
	if a < b {
		return a
	}
	return b
}
