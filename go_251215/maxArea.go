package main

func maxArea(height []int) int {
	// 最大面积
	// [1,8,6,2,5,4,8,3,7] -> 49 （7*(8-0+1)）
	l, r := 0, len(height)
	ans := 0

	for l < r {
		area := getmin3(height[l], height[r]) * (r - l + 1)
		if area > ans {
			ans = area
		}
		if height[l] < height[r] {
			l++
		} else {
			r--
		}
	}
	return ans
}

func getmin3(a, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
