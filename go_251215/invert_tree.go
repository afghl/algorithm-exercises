package main

func invertTree(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	// 交换
	left := root.Left
	right := root.Right
	root.Right = invertTree(left)
	root.Left = invertTree(right)
	return root
}
