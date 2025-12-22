package main

import "fmt"

func isPalindrome(x int) bool {
	getDigits := func(x int) []int {
		if x == 0 {
			return []int{0}
		}
		arr := make([]int, 0)
		for x > 0 {
			arr = append(arr, x%10) // 个位
			x /= 10
		}
		return arr
	}

	digits := getDigits(x)
	fmt.Printf("di: %v\n", digits)
	l, r := 0, len(digits)-1
	for l < r {
		if digits[l] != digits[r] {
			return false
		}
		l++
		r--
	}
	return true
}

func abs(x int) int {
	if x <= 0 {
		return -x
	}
	return x
}
