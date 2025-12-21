package main

import (
	"fmt"
	"sort"
)

func merge_simple_sort(nums1 []int, m int, nums2 []int, n int) {
	for i, num := range nums2 {
		fmt.Printf("i: %v,m: %v, m+i-1: %v", i, m, m+i-1)
		nums1[m+i] = num
	}
	sort.Ints(nums1)
}

func merge(nums1 []int, m int, nums2 []int, n int) {
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
