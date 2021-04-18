package main

import "math"

func isValidBST(root *TreeNode) bool {
	return travasel(root, math.MinInt64, math.MaxInt64)
}

func travasel(node *TreeNode, min, max int) bool {
	if node == nil {
		return true
	}

	if node.Val <= min || node.Val >= max {
		return false
	}

	// 左边的应该都小于node.Val,右边同理
	return travasel(node.Left, min, node.Val) && travasel(node.Right, node.Val, max)
}
