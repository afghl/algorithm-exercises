package main

import (
	"fmt"
	"sort"
)

func threeSum(nums []int) [][]int {
	sort.Ints(nums)

	fmt.Println(nums)

	result := make([][]int, 0)
	target := 0

	// 从小到大遍历
	for i, num := range nums {
		if num > target {
			continue
		}
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}

		l := i + 1
		r := len(nums) - 1

		for l < r {
			sum := num + nums[l] + nums[r]
			if sum == target {
				result = append(result, []int{num, nums[l], nums[r]})
				// 找到下一个不重复的数
				for l < r && nums[l] == nums[l+1] {
					l++
				}
				for l < r && nums[r] == nums[r-1] {
					r--
				}
				l++
				r--
			} else if sum < target {
				l++
			} else {
				r--
			}
		}
	}

	return result
}

func main() {
	result := threeSum([]int{-1, 0, 1, 2, -1, -4})
	threeSum([]int{0, 0, 0})
	fmt.Println(result)
}
