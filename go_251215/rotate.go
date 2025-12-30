package main

func rotate(nums []int, k int) {
	//空间复杂度为 O(1) 的 原地 算法解决
	if len(nums) == 0 {
		return
	}
	if k > len(nums) {
		k = k % len(nums)
	}
	// 两次翻转
	reverse := func(nums []int, l, r int) {
		for l < r {
			nums[l], nums[r] = nums[r], nums[l]
			l++
			r--
		}
	}
	reverse(nums, 0, len(nums)-1)
	reverse(nums, 0, k-1)
	reverse(nums, k, len(nums)-1)
}

func rotatematrix(matrix [][]int) {
	// 旋转其实就是横竖坐标互换一下，但是这里重点是原地旋转。
	// 这里有技巧...先转置，再左右翻转
	n := len(matrix)
	// 转置：只交换对角线一侧，避免重复交换
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
		}
	}
	// 左右翻转
	for i := 0; i < n; i++ {
		row := matrix[i]
		l, r := 0, n-1
		for l < r {
			row[l], row[r] = row[r], row[l]
			l++
			r--
		}
	}
}
