package main

// 感觉没必要搞太复杂。直接hash table。
func majorityElement(nums []int) int {
	occur := make(map[int]int, 0)
	for _, num := range nums {
		if occur[num] == 0 {
			occur[num] = 1
		} else {
			occur[num] = occur[num] + 1
		}
	}
	for k, v := range occur {
		if v > len(nums)/2 {
			return k
		}
	}
	return -1
}
