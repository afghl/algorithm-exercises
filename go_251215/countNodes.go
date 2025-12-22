package main

import "math"

func countNodes(root *TreeNode) int {
	l, r := root, root
	// 记录左、右子树的高度
	hl, hr := 0, 0
	for l != nil {
		l = l.Left
		hl++
	}
	for r != nil {
		r = r.Right
		hr++
	}
	// 如果左右子树的高度相同，则是一棵满二叉树
	if hl == hr {
		return int(math.Pow(2, float64(hl)) - 1)
	}
	// 如果左右高度不同，则按照普通二叉树的逻辑计算
	return 1 + countNodes(root.Left) + countNodes(root.Right)
}
