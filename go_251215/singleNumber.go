package main

func singleNumber(nums []int) int {
	single := 0
	for _, num := range nums {
		// xor运算，如果num == single，xor得到 0，
		// 这里主要是使用异或满足交换律、结合律的特点。很取巧的算法
		single ^= num
	}
	return single
}
