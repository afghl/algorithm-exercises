package main

import "math"

func getMinimumDifference(root *TreeNode) int {
	if root == nil {
		return 0
	}
	min := math.MaxInt32
	getmin := func(a, b int) int {
		if a < b {
			return a
		} else {
			return b
		}
	}

	var dfs func(n *TreeNode)
	var prev *TreeNode
	dfs = func(n *TreeNode) {
		if n == nil {
			return
		}
		dfs(n.Left)
		if prev != nil {
			min = getmin(n.Val-prev.Val, min)
		}
		prev = n
		dfs(n.Right)
	}
	dfs(root)

	return min
}
