package main

func twoSum(nums []int, target int) []int {
	m := make(map[int]int, len(nums))

	for i, num := range nums {
		if i2, has := m[target - num]; has {
			return []int{i, i2}
		}
		m[num] = i
	}

	return nil
}