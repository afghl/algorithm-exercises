package main

func containsNearbyDuplicate(nums []int, k int) bool {
	set := map[int]bool{}
	for i, num := range nums {
		// 当i超过一开始的滑动窗口之后，在集合中删除掉这个窗口的前一个元素
		// 这里直接用num去删除，是正确的，因为这个set保存的是“最近 k 个位置以内的元素”
		if i > k {
			delete(set, nums[i-k-1])
		}
		if set[num] {
			return true
		}
		set[num] = true
	}
	return false
}
