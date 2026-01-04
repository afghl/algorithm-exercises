package main

func searchRange(nums []int, target int) []int {
	if len(nums) == 0 {
		return []int{-1, -1}

	}
	leftIdx := binSearchRange(nums, target, true)
	rightIdx := binSearchRange(nums, target, false) - 1
	if leftIdx <= rightIdx && rightIdx < len(nums) && nums[leftIdx] == target && nums[rightIdx] == target {
		return []int{leftIdx, rightIdx}
	}
	return []int{-1, -1}
}

func binSearchRange(nums []int, target int, start bool) int {
	l, r, ans := 0, len(nums)-1, len(nums)
	for l <= r {
		m := (l + r) / 2
		num := nums[m]
		if num > target || (start && num >= target) {
			r = m - 1
			ans = m
		} else {
			l = m + 1
		}
	}
	return ans
}
