package main

func twoSum(nums []int, target int) []int {
	if len(nums) < 2 {
		return nil
	}
	for i := 0; i < len(nums)-1; i++ {
		l, r := i+1, len(nums)-1
		for l <= r {
			m := (l + r) / 2
			if s := nums[m] + nums[i]; s == target {
				return []int{i + 1, m + 1}
			} else if s < target {
				l = m + 1
			} else {
				r = m - 1
			}
		}
	}
	return nil
}

func twoSum1(nums []int, target int) []int {
	if len(nums) < 2 {
		return nil
	}
	for i := 0; i < len(nums)-1; i++ {
		for j := i + 1; j < len(nums); j++ {
			// fmt.Printf("i: %v, j: %v,  sum: %v\n", i, j, nums[j]+nums[i])
			if nums[j]+nums[i] == target {
				return []int{i, j}
			}
		}
	}
	return nil
}

// func main() {
// 	a := twoSum([]int{3, 2, 4}, 6)
// 	fmt.Printf("a:%v\n", a)
// }
