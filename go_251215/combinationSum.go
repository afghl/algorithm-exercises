package main

// 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。

// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
func combinationSum(candidates []int, target int) [][]int {
	// 这里重点是可以重复使用
	ans := make([][]int, 0)
	var dfs func(start, sum int, path []int)
	dfs = func(start, sum int, path []int) {
		if sum > target {
			return
		}
		if sum == target {
			arr := make([]int, len(path))
			copy(arr, path)
			ans = append(ans, arr)
			return
		}
		for i := start; i < len(candidates); i++ {
			can := candidates[i]
			path = append(path, can)
			dfs(i, sum+can, path)
			path = path[:len(path)-1]
		}
	}
	dfs(0, 0, []int{})
	return ans
}
