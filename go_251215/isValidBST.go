package main

import "math"

func isValidBST(root *TreeNode) bool {
	var dfs func(n *TreeNode, max, min int) bool
	dfs = func(n *TreeNode, max, min int) bool {
		if n == nil {
			return true
		}
		if n.Val >= max || n.Val <= min {
			return false
		}
		return dfs(n.Left, n.Val, min) &&
			dfs(n.Right, max, n.Val)
	}
	return dfs(root, math.MaxInt64, math.MinInt64)
}
