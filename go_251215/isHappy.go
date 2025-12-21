package main

var isHappyFind map[int]bool

func isHappy(n int) bool {
	isHappyFind = make(map[int]bool)
	return isHappyRecursive(n)
}
func isHappyRecursive(n int) bool {
	if isHappyFind[n] {
		return false
	} else {
		isHappyFind[n] = true
	}

	// 找到这个n所有位数

	digits := findDigits(n)
	sum := 0
	for _, d := range digits {
		sum += d * d
	}
	if sum == 1 {
		return true
	} else {
		return isHappyRecursive(sum)
	}
}

func findDigits(n int) []int {
	digits := make([]int, 0)
	for n >= 10 {
		digits = append(digits, n%10)
		n = n / 10
	}
	digits = append(digits, n)
	return digits
}
