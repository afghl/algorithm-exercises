package main

import "fmt"

// https://leetcode-cn.com/problems/combination-sum/
//给定一个无重复元素的数组 candidates 和一个目标数 target ，
//找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的数字可以无限制重复被选取。

func combinationSum(candidates []int, target int) [][]int {
	comb := make([]int, 0)
	ans := make([][]int, 0)

	dfs(candidates, &ans, &comb, target, 0)

	return ans
}

func dfs(candidates []int, ans *[][]int, com *[]int, target int, idx int) {
	// 当下标超过数组长度，返回
	if idx == len(candidates) {
		return
	}
	fmt.Printf("candidates: %v, ans: %v, com: %v, target: %v, idx: %v. \n",
		candidates, ans, com, target, idx)

	// 当前已经满足target的要求了，加到ans里，返回了
	if target == 0 {
		copy := append([]int(nil), *com...)
		*ans = append(*ans, copy)
		return
	}

	// 跳过当前这个元素
	dfs(candidates, ans, com, target, idx+1)

	// 选择当前这个元素，加到com里，然后继续走dfs
	curr := candidates[idx]

	if target-curr >= 0 {
		// 加到com
		*com = append(*com, curr)

		dfs(candidates, ans, com, target-curr, idx)
		// 做完dfs后要把curr从com里移除掉
		*com = (*com)[:len(*com)-1]
	}
}

func main() {
	combinationSum([]int{2, 3, 6, 7}, 7)
}
