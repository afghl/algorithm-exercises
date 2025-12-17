package main

import (
	"fmt"
	"strconv"
)

// 这里重点是区间是有序的
func summaryRanges(nums []int) []string {
	if len(nums) == 0 {
		return nil
	}
	ans := make([][]int, 0, len(nums))
	ans = append(ans, []int{nums[0]})
	for i := 1; i < len(nums); i++ {
		curr, last := nums[i], nums[i-1]
		if curr == last+1 {
			// 将curr放到ans的最后一个的后一个元素
			lastRange := ans[len(ans)-1]
			if len(lastRange) == 1 {
				ans[len(ans)-1] = append(lastRange, curr)
			} else {
				lastRange[1] = curr
			}
		} else {
			// 如果不连续，新增个区间
			ans = append(ans, []int{curr})
		}
	}
	mapToString := func(arr []int) string {
		if len(arr) == 1 {
			return strconv.Itoa(arr[0])
		}
		return fmt.Sprintf("%d->%d", arr[0], arr[1])
	}
	res := make([]string, len(ans))
	for i, intRange := range ans {
		res[i] = mapToString(intRange)
	}
	return res
}

func main() {
	summaryRanges([]int{0, 2, 3, 4, 6, 8, 9})
}
