package main

// 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
func combine(n int, k int) [][]int {

	ans := make([][]int, 0)
	path := make([]int, 0)
	var backtrace func(s int)
	backtrace = func(s int) {
		if len(path) == k {
			arr := make([]int, len(path))
			copy(arr, path)
			ans = append(ans, arr)
			return
		}
		for i := s; i <= n; i++ {
			path = append(path, i)
			backtrace(i + 1)
			path = path[:len(path)-1]
		}
	}
	backtrace(1)
	return ans
}
