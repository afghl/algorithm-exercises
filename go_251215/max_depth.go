package main

var max int

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	leftDepth := maxDepth(root.Left)
	rightDepth := maxDepth(root.Right)
	return getMax(leftDepth, rightDepth) + 1
}

func getMax(a, b int) int {
	m := a
	if b > m {
		m = b
	}
	return m
}
