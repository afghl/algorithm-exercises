package main

import (
	"fmt"
	"sort"
)

func merge(intervals [][]int) [][]int {
	if len(intervals) == 0 {
		return nil
	}
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	ans := make([][]int, 0, len(intervals))
	last := intervals[0]
	for i := 1; i < len(intervals); i++ {
		curr := intervals[i]
		if canmerge(last, curr) {
			last = []int{min(last[0], curr[0]), max(last[1], curr[1])}
		} else {
			ans = append(ans, last)
			last = curr
		}
	}
	ans = append(ans, last)
	return ans
}
func canmerge(a, b []int) bool {
	return a[1] >= b[0]
}

func merge_simple_sort(nums1 []int, m int, nums2 []int, n int) {
	for i, num := range nums2 {
		fmt.Printf("i: %v,m: %v, m+i-1: %v", i, m, m+i-1)
		nums1[m+i] = num
	}
	sort.Ints(nums1)
}

func merge2(nums1 []int, m int, nums2 []int, n int) {
	ans := make([]int, 0, m+n)
	i1, i2 := 0, 0
	for i1 < m && i2 < n {
		if nums1[i1] < nums2[i2] {
			ans = append(ans, nums1[i1])
			i1++
		} else {
			ans = append(ans, nums2[i2])
			i2++
		}
	}
	if i1 < m {
		ans = append(ans, nums1[i1:]...)
	}
	if i2 < n {
		ans = append(ans, nums2[i2:]...)
	}
	copy(nums1, ans)
}
