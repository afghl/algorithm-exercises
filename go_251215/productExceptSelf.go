package main

// 这样不引入额外空间
func productExceptSelf(nums []int) []int {
	length := len(nums)
	answer := make([]int, length)

	// answer[i] 表示索引 i 左侧所有元素的乘积
	// 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
	answer[0] = 1
	for i := 1; i < length; i++ {
		answer[i] = nums[i-1] * answer[i-1]
	}

	// R 为右侧所有元素的乘积
	// 刚开始右边没有元素，所以 R = 1
	R := 1
	for i := length - 1; i >= 0; i-- {
		// 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
		answer[i] = answer[i] * R
		// R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
		R *= nums[i]
	}
	return answer
}

func productExceptSelf1(nums []int) []int {
	right := make([]int, len(nums))
	left := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		if i == 0 {
			left[i] = 1
		} else {
			left[i] = nums[i-1] * left[i-1]
		}
	}
	for i := len(nums) - 1; i >= 0; i-- {
		if i == len(nums)-1 {
			right[i] = 1
		} else {
			right[i] = right[i+1] * nums[i+1]
		}
	}
	res := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		res[i] = left[i] * right[i]
	}
	return res
}
