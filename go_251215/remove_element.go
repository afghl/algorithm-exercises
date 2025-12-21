package main

func removeElement(nums []int, val int) int {
	head, tail := 0, len(nums)-1
	for head <= tail {
		if nums[head] != val {
			head++
		} else {
			nums[head] = nums[tail]
			tail--
		}
	}
	return head

}
