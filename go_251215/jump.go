package main

import (
	"math"
)

func jump(nums []int) int {
	// 整一个数组维护跳到这里大的最小次数，每次迭代维护这个数组
	minSumSteps := make([]int, len(nums))
	for i := 1; i < len(nums); i++ {
		minSumSteps[i] = math.MaxInt
	}

	for i := 0; i < len(nums); i++ {
		step := nums[i]
		// 更新minSumSteps的项
		for j := 1; j <= step && i+j < len(nums); j++ {
			minSumSteps[i+j] = min(minSumSteps[i+j], minSumSteps[i]+1)
		}
	}
	return minSumSteps[len(minSumSteps)-1]
}
