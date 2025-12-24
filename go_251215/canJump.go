package main

func canJump(nums []int) bool {
	if len(nums) <= 1 {
		return true
	}
	getMin := func(a, b int) int {
		if a < b {
			return a
		} else {
			return b
		}
	}
	for i := len(nums) - 1; i > 0; {
		minPrev := i
		found := false
		for distance := 1; distance <= i; distance++ {
			prev := i - distance
			if nums[prev] >= distance {
				found = true
				minPrev = getMin(minPrev, prev)
			}
		}
		if !found {
			return false
		}
		i = minPrev
	}
	return true
}
