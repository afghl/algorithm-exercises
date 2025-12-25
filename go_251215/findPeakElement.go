package main

func findPeakElement(nums []int) int {
	if len(nums) <= 1 {
		return 0
	}
	// 这里重点是要设计logn的算法
	l, r := 0, len(nums)-1
	for l < r {
		m := l + (r-l)/2
		// 如果右边更高，可以舍弃左半边
		if nums[m] < nums[m+1] {
			l = m + 1
		} else {
			r = m
		}
	}
	return l
}
