package main

func rotate(matrix [][]int) {
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
