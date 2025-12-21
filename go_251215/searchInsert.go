package main

func searchInsert(nums []int, target int) int {
	return recursiveSearchInsert(nums, target, 0, len(nums))
}

func recursiveSearchInsert(nums []int, target, l, r int) int {
	if l >= r {
		return -1
	}
	m := (l + r) / 2
	if nums[m] == target {
		return m
	} else if nums[m] > target {
		return recursiveSearchInsert(nums, target, l, m)
	} else {
		return recursiveSearchInsert(nums, target, m+1, r)
	}
}
