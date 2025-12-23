package main

func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}
	n := &TreeNode{Val: preorder[0]}
	if len(preorder) == 1 {
		return n
	}
	i := 0
	for ; i < len(inorder); i++ {
		if inorder[i] == preorder[0] {
			break
		}
	}
	// 如果找到左子树在inorder是0..i，那么说明有i-1个左子树节点
	n.Left = buildTree(preorder[1:i+1], inorder[0:i])
	n.Right = buildTree(preorder[i+1:], inorder[i+1:])
	return n
}
