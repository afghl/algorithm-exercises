package main

func twoSum(nums []int, target int) []int {
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
