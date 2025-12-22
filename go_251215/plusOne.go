package main

func plusOne(digits []int) []int {
	res := make([]int, len(digits)+1)
	carry := 1
	for i := len(digits) - 1; i >= 0; i-- {
		r := digits[i] + carry
		if r >= 10 {
			r = r - 10
			carry = 1
		} else {
			carry = 0
		}
		res[i+1] = r
	}
	if carry == 1 {
		res[0] = 1
		return res
	} else {
		return res[1:]
	}
}
