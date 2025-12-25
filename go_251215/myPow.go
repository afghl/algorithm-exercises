package main

import "fmt"

func myPow(x float64, n int) float64 {
	if n >= 0 {
		return myPowRecursive(x, n)
	} else {
		return 1.0 / myPowRecursive(x, n)
	}

}

func myPowRecursive(x float64, n int) float64 {
	if n == 0 {
		return 1
	}
	if n == 1 {
		return x
	}
	fmt.Printf("mypowre: %v, %v\n", x, n)

	// 2^10 = 1024 = (2*2)^5 = (2*2*2)^2.5= (2*2*2*2)^1.25 此路不通，没有缩减问题规模
	// 问题是如何分治： 2^10 = 2^5 * 2^5 = 2^2.5 *2^2.5 *2^2.5 *2^2.5
	y := myPowRecursive(x, n/2)
	if n%2 == 0 {
		return y * y
	}
	return y * y * x
}
