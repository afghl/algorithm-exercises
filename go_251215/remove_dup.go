package main

func removeDuplicates(nums []int) int {
	// 双指针，fast跳过所有重复的元素，然后就赋值给slow
	if len(nums) < 1 {
		return len(nums)
	}
	slow, fast := 1, 1
	for ; fast < len(nums); fast++ {
		if nums[fast] == nums[fast-1] {
			continue
		}
		// 找到当前的fast指向的元素，已经跳过重复元素，所以这个fast的元素赋值给slow
		nums[slow] = nums[fast]
		slow++
	}
	return slow
}
