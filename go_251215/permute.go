package main

func permute(nums []int) [][]int {
	used := make([]bool, len(nums))
	res := make([][]int, 0)
	var backtrace func(path []int)
	backtrace = func(path []int) {
		if len(path) == len(nums) {
			res = append(res, path)
			return
		}
		for i, num := range nums {
			if used[i] {
				continue
			}
			used[i] = true
			newpath := append([]int(nil), path...) // 复制 path 到新底层数组
			newpath = append(newpath, num)
			backtrace(newpath)
			used[i] = false
		}
	}
	backtrace([]int{})
	return res
}
