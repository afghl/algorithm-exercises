package main

func hammingWeight(n int) int {
	nums := [31]int{}
	for i := 0; i < len(nums); i++ {
		nums[i] = 1 << i
	}
	res := 0
	for n >= 1 {
		i := 0
		for ; i < len(nums); i++ {
			if n < nums[i] {
				break
			}
		}
		res += 1
		n = n - nums[i-1]
	}
	return res
}
