package main

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return mirror(root.Left, root.Right)
}

// mirror 这里需要比较的是 左右两个节点一致
func mirror(a, b *TreeNode) bool {
	if a == nil && b == nil {
		return true
	}
	if a == nil || b == nil {
		return false
	}
	if a.Val != b.Val {
		return false
	}
	return mirror(a.Left, b.Right) && mirror(a.Right, b.Left)
}
