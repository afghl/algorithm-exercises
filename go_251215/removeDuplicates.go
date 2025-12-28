package main

import "fmt"

func removeDuplicates(nums []int) int {
	if len(nums) <= 2 {
		return len(nums)
	}
	// 类似的，也是fast指针跳过重复元素
	slow, fast := 2, 2
	for fast < len(nums) {
		fmt.Printf("slow: %v, fast:%v, nums[slow-2]: %v, nums[fast]: %v", slow, fast, nums[slow-2], nums[fast])
		// 如果隔开两个后，slow
		if nums[slow-2] != nums[fast] {
			nums[slow] = nums[fast]
			slow++
		}
		fast++

	}
	return slow
}

func removeDuplicates1(nums []int) int {
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
